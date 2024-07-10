package com.example.shift_pizza_2024

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.shift_pizza_2024.history.HistoryRoute
import com.example.shift_pizza_2024.history.HistoryScreen
import com.example.shift_pizza_2024.history.HistoryViewModel
import com.example.shift_pizza_2024.history.HistoryViewModelFactory
import com.example.shift_pizza_2024.network.PizzaRepository
import com.example.shiftintensivelivecoding.details.DetailsRoute
import com.example.shiftintensivelivecoding.details.DetailsScreen

@Composable
fun MainScreen(repository: PizzaRepository) {
    val navController = rememberNavController()

    Surface {
        NavHost(navController = navController, startDestination = HistoryRoute) {
            composable<HistoryRoute> {
                val viewModel: HistoryViewModel = viewModel(factory = HistoryViewModelFactory(repository))
                HistoryScreen(
                    viewModel,
                    onItemSelected = { navController.navigate(DetailsRoute(pizzaId = it)) },
                )
            }
            composable<DetailsRoute> {
                val destination = it.toRoute<DetailsRoute>()
                DetailsScreen(
                    pizzaId = destination.pizzaId,
                    repository = repository,
                )
            }
        }
    }
}