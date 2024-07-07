package com.example.shift_pizza_2024.network

import com.example.shift_pizza_2024.data.PizzasResponse
import retrofit2.http.GET

interface LoansApi {
    @GET("catalog")
    suspend fun getCatalog(): List<PizzasResponse>
}