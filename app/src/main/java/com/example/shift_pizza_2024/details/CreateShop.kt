package com.example.shift_pizza_2024.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.window.Dialog
import com.example.shift_pizza_2024.data.payment.CreatePizzaPaymentPizzaDto
import com.example.shift_pizza_2024.data.pizza.Pizza
import com.example.shift_pizza_2024.data.pizza.PizzaDough
import com.example.shift_pizza_2024.data.pizza.PizzaIngredient
import com.example.shift_pizza_2024.data.pizza.PizzaSize

@Composable
fun CreateShop(pizza: Pizza) {
    var showDialog by remember { mutableStateOf(false) }
    var id by remember { mutableStateOf(0L) }
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    // Предполагаем, что у вас есть начальные списки для toppings, sizes, doughs
    var toppings by remember { mutableStateOf(listOf<PizzaIngredient>()) }
    var sizes by remember { mutableStateOf(listOf<PizzaSize>()) }
    var doughs by remember { mutableStateOf(listOf<PizzaDough>()) }

    Button(onClick = { showDialog = true }) {
        Text("Создать заказ")
    }

    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            // Содержимое диалога
            Column {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Название пиццы") }
                )
                // Добавьте другие поля для ввода остальных данных
                // ...

                Button(onClick = {
                    // Создайте экземпляр CreatePizzaPaymentPizzaDto с собранными данными
                    val pizzaDto = CreatePizzaPaymentPizzaDto(
                        id = id,
                        name = name,
                        toppings = toppings,
                        description = description,
                        sizes = sizes,
                        doughs = doughs
                    )
                    // Обработайте созданный экземпляр pizzaDto
                    // ...

                    showDialog = false
                }) {
                    Text("Подтвердить")
                }
            }
        }
    }
}