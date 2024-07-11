package com.example.shift_pizza_2024.shopping_cart

import com.example.shift_pizza_2024.data.pizza.Pizza

interface ShopState {
    data object Initial : ShopState
    data object Loading : ShopState
    data class Failure(val message: String?) : ShopState
    data class Content(val pizzas: List<Pizza>) : ShopState
}