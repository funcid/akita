package me.func.akita.dto.resp

import com.fasterxml.jackson.annotation.JsonProperty

data class Event(
    val type: String?,
    val value: Any?,
    @JsonProperty("instance") val instance: String? = null,
)
