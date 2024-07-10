package com.example.shift_pizza_2024.history

import com.example.shift_pizza_2024.data.Pizza

sealed interface HistoryState {

    data object Initial : HistoryState
    data object Loading : HistoryState
    data class Failure(val message: String?) : HistoryState
    data class Content(val pizzas: List<Pizza>) : HistoryState
}