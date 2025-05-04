package me.func.akita.dto.req

data class Capability(
    val type: String,
    val state: Map<String, Any>,
)
