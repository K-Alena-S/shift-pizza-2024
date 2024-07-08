package com.example.shift_pizza_2024.data

import kotlinx.serialization.Serializable

@Serializable
data class PizzasResponse (
    val success: Boolean,
    val reason: String?= null,
    val catalog: List<Pizza>
)