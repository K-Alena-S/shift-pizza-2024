package com.example.shiftintensivelivecoding.details

import com.example.shift_pizza_2024.data.Pizza

interface DetailsState {

	data object Initial : DetailsState
	data object Loading : DetailsState
	data class Failure(val message: String?) : DetailsState
	data class Content(val loan: Pizza) : DetailsState
}