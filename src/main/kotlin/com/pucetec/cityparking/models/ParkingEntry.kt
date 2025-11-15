package com.cityparking.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class ParkingEntry(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(unique = true)
    val plate: String,

    val ownerName: String,

    val entryTime: LocalDateTime = LocalDateTime.now()
)
