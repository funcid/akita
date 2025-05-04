package me.func.akita.dto.resp

import com.fasterxml.jackson.annotation.JsonProperty

data class QuasarInfo(
    @JsonProperty("device_id") val deviceId: String,
    val platform: String,
    @JsonProperty("device_color") val deviceColor: String,
)
