package me.func.akita.dto.resp

import com.fasterxml.jackson.annotation.JsonProperty

data class Room(
    val id: String,
    val name: String,
    val aliases: List<String>? = emptyList(),
    @JsonProperty("household_id") val householdId: String,
    val devices: List<String>,
)
