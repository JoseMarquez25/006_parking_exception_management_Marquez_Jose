package com.cityparking.exceptions.handler

import com.cityparking.exceptions.*
import com.cityparking.handler.ErrorResponse
import com.pucetec.cityparking.exceptions.handlers.BlacklistedPlateException
import com.pucetec.cityparking.exceptions.handlers.CarAlreadyParkedException
import com.pucetec.cityparking.exceptions.handlers.CarNotFoundException
import com.pucetec.cityparking.exceptions.handlers.InvalidPlateFormatException
import com.pucetec.cityparking.exceptions.handlers.ParkingFullException
import com.pucetec.cityparking.exceptions.handlers.ParkingTimeExceededException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ParkingFullException::class)
    fun handleParkingFull(ex: ParkingFullException): ResponseEntity<ErrorResponse> {
        val response = ErrorResponse(ex.message ?: "El parqueadero está lleno")
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }


    @ExceptionHandler(CarAlreadyParkedException::class)
    fun handleCarAlready(ex: CarAlreadyParkedException): ResponseEntity<ErrorResponse> {
        val response = ErrorResponse(ex.message ?: "El vehículo ya está registrado en el parqueadero")
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(InvalidPlateFormatException::class)
    fun handleInvalidPlate(ex: InvalidPlateFormatException): ResponseEntity<ErrorResponse> {
        val response = ErrorResponse(ex.message ?: "Formato de placa inválido")
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(BlacklistedPlateException::class)
    fun handleBlacklisted(ex: BlacklistedPlateException): ResponseEntity<ErrorResponse> {
        val response = ErrorResponse(ex.message ?: "Placa en lista negra")
        return ResponseEntity(response, HttpStatus.FORBIDDEN)
    }

    @ExceptionHandler(CarNotFoundException::class)
    fun handleNotFound(ex: CarNotFoundException): ResponseEntity<ErrorResponse> {
        val response = ErrorResponse(ex.message ?: "Vehículo no encontrado")
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(ParkingTimeExceededException::class)
    fun handleTimeExceeded(ex: ParkingTimeExceededException): ResponseEntity<ErrorResponse> {
        val response = ErrorResponse(ex.message ?: "Tiempo máximo de parqueo excedido")
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }
}
