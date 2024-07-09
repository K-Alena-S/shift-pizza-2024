package com.example.shiftintensivelivecoding.details

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shift_pizza_2024.R
import com.example.shift_pizza_2024.data.Pizza
import com.example.shift_pizza_2024.formatAmountText
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun ContentComponent(
	pizza: Pizza,
) {
	Column {
		DetailItem(nameResId = R.string.details_name, value = pizza.name)
		DetailItem(nameResId = R.string.details_description, value = pizza.description)
		DetailItem(nameResId = R.string.details_calories, value = pizza.calories.toString())
		DetailItem(nameResId = R.string.details_protein, value = pizza.protein)
		DetailItem(nameResId = R.string.details_total_fat, value = pizza.totalFat)
		DetailItem(nameResId = R.string.details_carbohydrates, value = pizza.carbohydrates)
		DetailItem(nameResId = R.string.details_sodium, value = pizza.sodium)
//
//		DetailItem(nameResId = R.string.details_ingredients, value = formatAmountText(pizza.ingredients))
//		DetailItem(nameResId = R.string.details_toppings, value = formatAmountText(pizza.toppings))
	}
}

@Composable
private fun DetailItem(@StringRes nameResId: Int, value: String) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(vertical = 8.dp, horizontal = 16.dp),
	) {
		Text(text = stringResource(nameResId), style = MaterialTheme.typography.labelLarge)
		Text(text = value, style = MaterialTheme.typography.bodyLarge)
	}
}
