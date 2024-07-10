package com.example.shiftintensivelivecoding.details

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shift_pizza_2024.R
import com.example.shift_pizza_2024.data.Ingredient
import com.example.shift_pizza_2024.data.Pizza
import com.example.shift_pizza_2024.data.PizzaIngredient
import com.example.shift_pizza_2024.network.LoadImageFromUrl
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

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
		DetailItem(nameResId = R.string.details_ingredients, value = "")
		FormatAmountText(pizza.ingredients)
	}
}
@Composable
fun FormatAmountText(ingredients: List<PizzaIngredient>) {
	val scrollState = rememberScrollState()

	Column(modifier = Modifier.verticalScroll(scrollState)) {
		for (ingredient in ingredients) {
			val nameId = when (ingredient.name) {
				Ingredient.PINEAPPLE -> R.string.ingredient_pineapple
				Ingredient.MOZZARELLA -> R.string.ingredient_mozzarella
				Ingredient.PEPERONI -> R.string.ingredient_peperoni
				Ingredient.GREEN_PEPPER -> R.string.ingredient_green_pepper
				Ingredient.MUSHROOMS -> R.string.ingredient_mushrooms
				Ingredient.BASIL -> R.string.ingredient_basil
				Ingredient.CHEDDAR -> R.string.ingredient_cheddar
				Ingredient.PARMESAN -> R.string.ingredient_parmesan
				Ingredient.FETA -> R.string.ingredient_feta
				Ingredient.HAM -> R.string.ingredient_ham
				Ingredient.PICKLE -> R.string.ingredient_pickle
				Ingredient.TOMATO -> R.string.ingredient_tomato
				Ingredient.BACON -> R.string.ingredient_bacon
				Ingredient.ONION -> R.string.ingredient_onion
				Ingredient.CHILE -> R.string.ingredient_chile
				Ingredient.SHRIMPS -> R.string.ingredient_shrimps
				Ingredient.CHICKEN_FILLET -> R.string.ingredient_chicken_fillet
				Ingredient.MEATBALLS -> R.string.ingredient_meatballs
			}
			val name = stringResource(nameId)
			Row(modifier = Modifier.padding(4.dp)) {
				Text(text = "$name: ")
				Text(text = "${ingredient.cost}₽")
				LoadImageFromUrl(url = ingredient.img)
			}

		}
	}
}

@Composable
fun DetailItem(@StringRes nameResId: Int, value: String) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(vertical = 8.dp, horizontal = 16.dp),
	) {
		Text(text = stringResource(nameResId), style = MaterialTheme.typography.labelLarge)
		Text(text = value, style = MaterialTheme.typography.bodyLarge)
	}
}
