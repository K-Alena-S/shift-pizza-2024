package com.example.shift_pizza_2024.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shift_pizza_2024.network.PizzaRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val pizzaRepository: PizzaRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<HistoryState>(HistoryState.Initial)
    val state: StateFlow<HistoryState> = _state

    fun loadPizzas() {
        viewModelScope.launch {
            _state.value = HistoryState.Loading

            try {
                val pizzas = pizzaRepository.getCatalog()
                _state.value = HistoryState.Content(pizzas)
            } catch (ce: CancellationException) {
                throw ce
            } catch (ex: Exception) {
                _state.value = HistoryState.Failure(ex.localizedMessage.orEmpty())
            }
        }
    }
}