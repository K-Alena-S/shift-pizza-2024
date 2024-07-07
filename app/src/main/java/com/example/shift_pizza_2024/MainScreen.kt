package com.example.shift_pizza_2024

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shift_pizza_2024.history.HistoryRoute
import com.example.shift_pizza_2024.history.HistoryScreen
import com.example.shift_pizza_2024.network.LoanRepository

@Composable
fun MainScreen(repository: LoanRepository) {
    val navController = rememberNavController()

    Surface {
        NavHost(navController = navController, startDestination = HistoryRoute) {
            composable<HistoryRoute> {
                HistoryScreen(
                    repository = repository,
                    onItemSelected = { /*TODO Добавит навигацию на экран деталей*/ },
                )
            }
        }
    }
}