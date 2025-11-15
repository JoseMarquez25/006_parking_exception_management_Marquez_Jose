package com.cityparking.controller

import com.cityparking.model.ParkingEntry
import com.cityparking.service.ParkingService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/parking/entries")
class ParkingController(
    private val service: ParkingService
) {

    data class EntryRequest(val plate: String, val ownerName: String)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun registerEntry(@RequestBody req: EntryRequest): ParkingEntry {
        return service.registerEntry(req.plate, req.ownerName)
    }

    @GetMapping("/{plate}")
    fun getEntry(@PathVariable plate: String): ParkingEntry {
        return service.getEntry(plate)
    }

    @DeleteMapping("/{plate}")
    fun registerExit(@PathVariable plate: String): Map<String, String> {
        service.registerExit(plate)
        return mapOf("message" to "Auto con placa $plate salió correctamente del parqueadero.")
    }

}
