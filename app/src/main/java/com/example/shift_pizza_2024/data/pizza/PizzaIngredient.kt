package com.example.shift_pizza_2024.data.pizza

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class PizzaIngredient(
    val name: Ingredient,
    @Contextual
    val cost: Long,
    val img: String
)
