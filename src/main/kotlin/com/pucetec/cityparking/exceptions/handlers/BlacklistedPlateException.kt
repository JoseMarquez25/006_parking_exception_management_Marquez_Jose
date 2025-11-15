package com.pucetec.cityparking.exceptions.handlers

class BlacklistedPlateException(plate: String) :
    RuntimeException("La placa $plate está en lista negra y no puede ingresar.")
