package com.pucetec.cityparking.exceptions.handlers

class ParkingTimeExceededException :
    RuntimeException("El tiempo de permanencia supera las 8 horas permitidas.")
