package com.example.f1drivers.domain.model.team

data class Team(
    val id: Int,
    val name: String,
    val fullName: String,
    val base: String,
    val teamChief: String,
    val technicalChief: String,
    val powerUnit: String,
    val firstEntry: Int,
    val worldChampionships: Int,
    val highestRaceFinish: Int,
    val highestGridPosition: Int,
    val fastestLaps: Int,
    val imageUrl: String,
    val color: String,
    val standingsPosition: Int? = null,
    val standingsPoints: Int? = null
) 