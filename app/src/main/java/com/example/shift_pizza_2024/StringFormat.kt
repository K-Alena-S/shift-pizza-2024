package com.example.shift_pizza_2024

import androidx.compose.runtime.Composable
import com.example.shift_pizza_2024.data.PizzaIngredient
import java.text.NumberFormat
import java.util.Locale

@Composable
fun formatAmountText(amount: List<PizzaIngredient>): String {
    val numberFormatter = NumberFormat.getNumberInstance(Locale.getDefault())
    return numberFormatter.format(amount)
}
