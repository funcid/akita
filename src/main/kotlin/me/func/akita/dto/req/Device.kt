package me.func.akita.dto.req

data class Device(
    val id: String,
    val actions: List<Capability>,
)
