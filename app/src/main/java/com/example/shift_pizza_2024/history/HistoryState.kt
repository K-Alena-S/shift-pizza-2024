package com.example.shift_pizza_2024.history

import com.example.shift_pizza_2024.data.PizzasResponse

sealed interface HistoryState {

    data object Initial : HistoryState
    data object Loading : HistoryState
    data class Failure(val message: String?) : HistoryState
    data class Content(val loans: List<PizzasResponse>) : HistoryState
}