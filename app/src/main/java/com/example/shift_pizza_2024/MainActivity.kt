package com.example.shift_pizza_2024

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.shift_pizza_2024.network.LoanRepository

class MainActivity : AppCompatActivity() {

    val repository = LoanRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(repository = repository)
        }
    }
}