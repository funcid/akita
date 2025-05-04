package me.func.akita.dto.resp

import com.fasterxml.jackson.annotation.JsonProperty

data class Device(
    val id: String,
    val name: String,
    val aliases: List<String>? = emptyList(),
    val type: String,
    @JsonProperty("external_id") val externalId: String,
    @JsonProperty("skill_id") val skillId: String,
    @JsonProperty("household_id") val householdId: String,
    val room: String?,
    val groups: List<String>,
    val capabilities: List<me.func.akita.dto.resp.Capability>,
    val properties: List<me.func.akita.dto.resp.Property>,
    @JsonProperty("quasar_info") val quasarInfo: me.func.akita.dto.resp.QuasarInfo?,
)
