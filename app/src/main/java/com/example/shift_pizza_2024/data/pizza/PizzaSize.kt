package com.example.shift_pizza_2024.data.pizza

import kotlinx.serialization.Serializable

@Serializable
data class PizzaSize (
    val name: SizeP,
    val price: Int
)

