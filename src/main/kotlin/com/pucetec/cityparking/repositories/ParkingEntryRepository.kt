package com.cityparking.repository

import com.cityparking.model.ParkingEntry
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ParkingEntryRepository : JpaRepository<ParkingEntry, Long> {
    fun findByPlate(plate: String): Optional<ParkingEntry>
}
