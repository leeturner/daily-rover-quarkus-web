package com.leeturner.dailyroverweb.api.model.photo

import com.fasterxml.jackson.annotation.JsonProperty

data class Camera(
    val id: Int,
    val name: String,
    @JsonProperty("rover_id")
    val roverId: Int,
    @JsonProperty("full_name")
    val fullName: String
)
