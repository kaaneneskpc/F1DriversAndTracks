package com.example.f1drivers.domain.model.driver

data class Driver(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val number: Int,
    val team: String,
    val imageUrl: String,
    val polePositions: Int,
    val championships: Int,
    val careerPoints: Int,
    val podiums: Int,
    val nationality: String
) 