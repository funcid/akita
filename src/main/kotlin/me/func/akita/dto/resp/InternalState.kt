package me.func.akita.dto.resp

import com.fasterxml.jackson.annotation.JsonProperty

data class InternalState(
    @JsonProperty("color_id") val colorId: String?,
)
