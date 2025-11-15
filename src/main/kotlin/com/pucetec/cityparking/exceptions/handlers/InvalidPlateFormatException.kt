package com.pucetec.cityparking.exceptions.handlers

class InvalidPlateFormatException(plate: String) :
    RuntimeException("La placa $plate no cumple el formato AAA-1234.")