package me.func.akita.dto.resp

import com.fasterxml.jackson.annotation.JsonProperty

data class CapabilityState(
    val instance: String,
    val value: Any?,
    @JsonProperty("internal_state") val internalState: me.func.akita.dto.resp.InternalState?,
)
