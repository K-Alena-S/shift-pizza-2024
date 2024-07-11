package com.example.shiftintensivelivecoding.details

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shift_pizza_2024.R
import com.example.shift_pizza_2024.data.pizza.Ingredient
import com.example.shift_pizza_2024.data.pizza.Pizza
import com.example.shift_pizza_2024.data.pizza.PizzaIngredient
import com.example.shift_pizza_2024.network.LoadImageFromUrl
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Dialog
import com.example.shift_pizza_2024.data.payment.CreatePizzaPaymentPizzaDto
import com.example.shift_pizza_2024.data.pizza.Dough
import com.example.shift_pizza_2024.data.pizza.PizzaDough
import com.example.shift_pizza_2024.data.pizza.PizzaSize

@Composable
fun ContentComponent(
	pizza: Pizza,
) {
	val scrollState = rememberScrollState()
	Column(modifier = Modifier.verticalScroll(scrollState)) {
		DetailItem(nameResId = R.string.details_name, value = pizza.name)
		DetailItem(nameResId = R.string.details_description, value = pizza.description)
		DetailItem(nameResId = R.string.details_calories, value = pizza.calories.toString())
		DetailItem(nameResId = R.string.details_protein, value = pizza.protein)
		DetailItem(nameResId = R.string.details_total_fat, value = pizza.totalFat)
		DetailItem(nameResId = R.string.details_carbohydrates, value = pizza.carbohydrates)
		DetailItem(nameResId = R.string.details_sodium, value = pizza.sodium)
		DetailItem(nameResId = R.string.details_ingredients, value = "")
		FormatAmountText(pizza.ingredients)

//		onCreateShop(pizza)

	}

}

@Composable
fun onCreateShop(pizza: Pizza) {
	var showDialog by remember { mutableStateOf(false) }
	var id by remember { mutableStateOf(0L) }
	var name by remember { mutableStateOf(pizza.name) }
	var description by remember { mutableStateOf("") }
	// Предполагаем, что у вас есть начальные списки для toppings, sizes, doughs
	var toppings by remember { mutableStateOf(listOf<PizzaIngredient>()) }
	var sizes by remember { mutableStateOf(listOf<PizzaSize>()) }
	var doughs by remember { mutableStateOf(listOf<PizzaDough>()) }

	Button(onClick = { showDialog = true }) {
		Text("Добавить в корзину")
	}

	if (showDialog) {
		Dialog(onDismissRequest = { showDialog = false }) {
			// Содержимое диалога
			val scrollState = rememberScrollState()
			Column(Modifier.verticalScroll(scrollState)) {
				ChooseDoughDialog { onDoughChosen ->
					doughs
				}
				ChooseIngredientsDialog { onIngredientsChosen ->
					toppings
				}

				Button(onClick = {
					val pizzaDto = CreatePizzaPaymentPizzaDto(
						id = id,
						name = name,
						toppings = toppings,
						description = description,
						sizes = sizes,
						doughs = doughs
					)

					showDialog = false
				}) {
					Text("Подтвердить")
				}
			}
		}
	}

}

@Composable
fun ChooseIngredientsDialog(onIngredientsChosen: (List<PizzaIngredient>) -> Unit) {
	val ingredients = Ingredient.values()
	val selectedIngredients = remember { mutableStateListOf<PizzaIngredient>() }

	Column(modifier = Modifier.background(Color.White)) {
		ingredients.forEach { ingredient ->
			Row(verticalAlignment = Alignment.CenterVertically) {
				Checkbox(
					checked = selectedIngredients.any { it.name == ingredient },
					onCheckedChange = { isChecked ->
						if (isChecked) {
							selectedIngredients.add(PizzaIngredient(name = ingredient, cost = 0L, img = "url_to_image"))
						} else {
							selectedIngredients.removeAll { it.name == ingredient }
						}
					}
				)
				Text(text = ingredient.name)
			}
		}
		Button(onClick = { onIngredientsChosen(selectedIngredients.toList()) }) {
			Text("Выбрать")
		}
	}
}

@Composable
fun ChooseDoughDialog(onDoughChosen: (Dough) -> Unit) {
	val doughTypes = Dough.values()
	var selectedDough by remember { mutableStateOf<Dough?>(null) }

	Dialog(onDismissRequest = {}) {
		Column(modifier = Modifier.background(Color.White)) {
			Text("Выберите тип теста:")
			doughTypes.forEach { dough ->
				Row(
					verticalAlignment = Alignment.CenterVertically,
					modifier = Modifier
						.fillMaxWidth()
						.clickable { selectedDough = dough }
						.padding(16.dp)
				) {
					RadioButton(
						selected = dough == selectedDough,
						onClick = { selectedDough = dough }
					)
					Text(text = dough.name)
				}
			}
			Button(
				onClick = { selectedDough?.let { onDoughChosen(it) } },
				enabled = selectedDough != null,
				modifier = Modifier.padding(top = 16.dp)
			) {
				Text("Продолжить")
			}
		}
	}
}


@Composable
fun FormatAmountText(ingredients: List<PizzaIngredient>) {
	Column() {
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
