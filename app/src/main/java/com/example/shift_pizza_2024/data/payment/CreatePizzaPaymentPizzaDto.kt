package com.example.shift_pizza_2024.data.payment

import com.example.shift_pizza_2024.data.pizza.PizzaDough
import com.example.shift_pizza_2024.data.pizza.PizzaIngredient
import com.example.shift_pizza_2024.data.pizza.PizzaSize

data class CreatePizzaPaymentPizzaDto(
    val id: Long,
    val name: String,
    val toppings: List<PizzaIngredient>,
    val description: String,
    val sizes: List<PizzaSize>,
    val doughs: List<PizzaDough>
)
