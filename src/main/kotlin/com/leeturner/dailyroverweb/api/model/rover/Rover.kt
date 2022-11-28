package com.leeturner.dailyroverweb.api.model.rover

import java.time.LocalDate

data class Rover(
    val id: Int,
    val name: String,
    val landingDate: LocalDate,
    val launchDate: LocalDate,
    val maxDate: LocalDate?,
    val maxSol: Int?,
    val status: String,
    val photoApiUrl: String,
)