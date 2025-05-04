package me.func.akita.dto.resp

data class Household(
    val id: String,
    val name: String,
    val aliases: List<String>? = emptyList(),
    val type: String,
)
