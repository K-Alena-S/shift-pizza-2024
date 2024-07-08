package com.example.shift_pizza_2024.data

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class Pizza(
    val id: Long,
    val name: String,
    val ingredients: PizzaIngredient,
    val toppings: PizzaIngredient,
    val description: String,
    val sizes: PizzaSize,
    val doughs: PizzaDough,
    @Contextual
    val calories: Number,
    val protein: String,
    val totalFat: String,
    val carbohydrates: String,
    val sodium: String,
    val allergens: Array<String>,
    val isVegetarian: Boolean,
    val isGlutenFree: Boolean,
    val isNew: Boolean,
    val isHit: Boolean,
    val img: String

)
