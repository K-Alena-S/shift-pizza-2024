package com.example.shift_pizza_2024.data

import kotlinx.serialization.Serializable

@Serializable
data class PizzasResponse (
    val succenss: Boolean,
    val reason: String,
    val catalog: Pizza
)