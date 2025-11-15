package com.cityparking.service

import com.cityparking.exceptions.*
import com.cityparking.model.ParkingEntry
import com.cityparking.repository.ParkingEntryRepository
import com.pucetec.cityparking.exceptions.handlers.BlacklistedPlateException
import com.pucetec.cityparking.exceptions.handlers.CarAlreadyParkedException
import com.pucetec.cityparking.exceptions.handlers.CarNotFoundException
import com.pucetec.cityparking.exceptions.handlers.InvalidPlateFormatException
import com.pucetec.cityparking.exceptions.handlers.ParkingFullException
import com.pucetec.cityparking.exceptions.handlers.ParkingTimeExceededException
import org.springframework.stereotype.Service
import java.time.Duration
import java.time.LocalDateTime

@Service
class ParkingService(
    private val repository: ParkingEntryRepository
) {

    private val blacklist = listOf("AAA-0001", "BBB-0002")
    private val plateRegex = Regex("^[A-Z]{3}-\\d{4}$")

    fun registerEntry(plate: String, ownerName: String): ParkingEntry {

        if (!plate.matches(plateRegex))
            throw InvalidPlateFormatException(plate)

        if (plate in blacklist)
            throw BlacklistedPlateException(plate)

        if (repository.count() >= 20)
            throw ParkingFullException()

        if (repository.findByPlate(plate).isPresent)
            throw CarAlreadyParkedException(plate)

        val entry = ParkingEntry(plate = plate, ownerName = ownerName)
        return repository.save(entry)
    }

    fun getEntry(plate: String): ParkingEntry =
        repository.findByPlate(plate)
            .orElseThrow { CarNotFoundException(plate) }

    fun registerExit(plate: String) {
        val entry = repository.findByPlate(plate)
            .orElseThrow { CarNotFoundException(plate) }

        val hours = Duration.between(entry.entryTime, LocalDateTime.now()).toHours()

        if (hours > 8)
            throw ParkingTimeExceededException()

        repository.delete(entry)
    }
}
