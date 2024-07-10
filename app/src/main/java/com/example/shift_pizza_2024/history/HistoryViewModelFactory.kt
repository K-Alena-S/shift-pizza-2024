package com.example.shift_pizza_2024.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shift_pizza_2024.network.PizzaRepository

class HistoryViewModelFactory(
    private val pizzaRepository: PizzaRepository,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == HistoryViewModel::class.java) { "Unknown ViewModel: $modelClass" }
        return HistoryViewModel(pizzaRepository) as T
    }
}