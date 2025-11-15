package com.pucetec.cityparking.exceptions.handlers

class CarNotFoundException(plate: String) :
    RuntimeException("No existe un auto registrado con placa $plate.")
