package com.pucetec.cityparking.exceptions.handlers

class CarAlreadyParkedException(plate: String) :
    RuntimeException("El auto con placa $plate ya está parqueado.")
