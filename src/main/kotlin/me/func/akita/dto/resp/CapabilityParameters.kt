package me.func.akita.dto.resp

import com.fasterxml.jackson.annotation.JsonProperty

data class CapabilityParameters(
    val instance: String?,
    val unit: String?,
    @JsonProperty("random_access") val randomAccess: Boolean?,
    val looped: Boolean?,
    val range: Range?,
    @JsonProperty("temperature_k") val temperatureK: TemperatureRange?,
    @JsonProperty("color_model") val colorModel: String?,
    @JsonProperty("color_scene") val colorScene: Any?,
)
