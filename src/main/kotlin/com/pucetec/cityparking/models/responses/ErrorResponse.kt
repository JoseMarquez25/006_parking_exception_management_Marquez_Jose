package com.cityparking.handler

data class ErrorResponse(
    val message: String,
    val timestamp: String = java.time.LocalDateTime.now().toString()
)
