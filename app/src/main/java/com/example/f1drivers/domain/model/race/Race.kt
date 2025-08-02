package com.example.f1drivers.domain.model.race

data class Race(
    val id: Int,
    val grandPrix: String,
    val country: String,
    val date: String,
    val winner: String,
    val winnerTeam: String,
    val winnerCode: String,
    val laps: Int,
    val time: String,
    val flagUrl: String,
    val winnerImageUrl: String,
    val teamImageUrl: String
) 