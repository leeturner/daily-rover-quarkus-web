package com.leeturner.dailyroverweb.api.model.photo

import java.time.LocalDate

data class PhotoResponse(
    val earthDate: LocalDate,
    val photos: List<Photo> = listOf()
)
