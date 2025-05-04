package me.func.akita.dto.resp

import com.fasterxml.jackson.annotation.JsonProperty

data class Capability(
    val reportable: Boolean,
    val retrievable: Boolean,
    val type: String,
    @JsonProperty("state_changed_at") val stateChangedAt: Double,
    @JsonProperty("last_updated") val lastUpdated: Double,
    val parameters: CapabilityParameters,
    val state: CapabilityState,
)
