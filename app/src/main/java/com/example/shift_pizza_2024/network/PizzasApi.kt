package com.example.shift_pizza_2024.network

import com.example.shift_pizza_2024.data.pizza.PizzasResponse
import retrofit2.http.GET

interface PizzasApi {
    @GET("pizza/catalog")
    suspend fun getCatalog(): PizzasResponse
}