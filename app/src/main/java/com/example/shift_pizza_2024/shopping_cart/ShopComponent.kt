package com.example.shift_pizza_2024.shopping_cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.shift_pizza_2024.R
import com.example.shift_pizza_2024.data.pizza.Pizza
import com.example.shiftintensivelivecoding.details.DetailItem

@Composable
fun ContentComponent(
    pizza: Pizza,
){
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        DetailItem(nameResId = R.string.details_name, value = pizza.name)
    }

}