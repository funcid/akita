package me.func.akita.dto.resp

import com.fasterxml.jackson.annotation.JsonProperty

data class Property(
    val type: String,
    val reportable: Boolean,
    val retrievable: Boolean,
    val parameters: PropertyParameters?,
    val state: Any?,
    @JsonProperty("last_updated") val lastUpdated: Double,
)
