package com.example.shift_pizza_2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.shift_pizza_2024.network.PizzaRepository

class MainActivity : ComponentActivity() {

    val repository = PizzaRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(repository = repository)
        }
    }
}