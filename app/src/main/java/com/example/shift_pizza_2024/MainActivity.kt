package com.example.shift_pizza_2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.shift_pizza_2024.network.LoanRepository

class MainActivity : ComponentActivity() {

    val repository = LoanRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(repository = repository)
        }
    }
}