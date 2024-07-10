package com.example.shift_pizza_2024

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.shift_pizza_2024.history.HistoryRoute
import com.example.shift_pizza_2024.history.HistoryScreen
import com.example.shift_pizza_2024.network.PizzaRepository
import com.example.shiftintensivelivecoding.details.DetailsRoute
import com.example.shiftintensivelivecoding.details.DetailsScreen

@Composable
fun MainScreen(repository: PizzaRepository) {
    val navController = rememberNavController()

    Surface {
        NavHost(navController = navController, startDestination = HistoryRoute) {
            composable<HistoryRoute> {
                HistoryScreen(
                    repository = repository,
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