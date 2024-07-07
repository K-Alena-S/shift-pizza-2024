package com.example.shift_pizza_2024.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.Contextual

@Serializable
data class PizzaSize (
    val name: Size,
    @Contextual
    val prise: Number
)

