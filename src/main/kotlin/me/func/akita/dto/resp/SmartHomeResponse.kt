package me.func.akita.dto.resp

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class SmartHomeResponse(
    val status: String,
    @JsonProperty("request_id") val requestId: String,
    val rooms: List<Room>? = null,
    val groups: List<Group>? = null,
    val devices: List<Device>? = null,
    val scenarios: List<Scenario>? = null,
    val households: List<Household>? = null,
)
