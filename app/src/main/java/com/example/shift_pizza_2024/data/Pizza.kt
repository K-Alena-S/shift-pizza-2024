package com.example.shift_pizza_2024.data

import kotlinx.serialization.Serializable

@Serializable
data class Pizza(
    val id: Long,
    val name: String,
    val ingredients: PizzaIngredient,
    val toppings: PizzaIngredient,
    val description: String,
    val sizes: PizzaSize,


)
