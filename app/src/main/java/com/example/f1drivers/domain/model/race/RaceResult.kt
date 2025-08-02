package com.example.f1drivers.domain.model.race

data class RaceResult(
    val position: String,
    val driverNumber: Int,
    val driverName: String,
    val driverCode: String,
    val team: String,
    val laps: Int,
    val time: String,
    val points: Int,
    val driverImageUrl: String,
    val teamImageUrl: String
) 