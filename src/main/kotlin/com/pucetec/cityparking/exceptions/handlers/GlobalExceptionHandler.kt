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
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ParkingFullException::class)
    fun handleParkingFull(ex: ParkingFullException) =
        ErrorResponse(ex.message!!)

    @ExceptionHandler(CarAlreadyParkedException::class)
    fun handleCarAlready(ex: CarAlreadyParkedException) =
        ErrorResponse(ex.message!!)

    @ExceptionHandler(InvalidPlateFormatException::class)
    fun handleInvalidPlate(ex: InvalidPlateFormatException) =
        ErrorResponse(ex.message!!)

    @ExceptionHandler(BlacklistedPlateException::class)
    fun handleBlacklisted(ex: BlacklistedPlateException) =
        ErrorResponse(ex.message!!)

    @ExceptionHandler(CarNotFoundException::class)
    fun handleNotFound(ex: CarNotFoundException) =
        ErrorResponse(ex.message!!)

    @ExceptionHandler(ParkingTimeExceededException::class)
    fun handleTimeExceeded(ex: ParkingTimeExceededException) =
        ErrorResponse(ex.message!!)
}
