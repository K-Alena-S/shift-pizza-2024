package com.example.shift_pizza_2024

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.stringResource
import com.example.shift_pizza_2024.data.Ingredient
import com.example.shift_pizza_2024.data.PizzaIngredient

//@Composable
//fun formatAmountText(ingredients: List<PizzaIngredient>): String {
//    return ingredients.joinToString(separator = ", ") { ingredient ->
//        val nameId = when (ingredient.name) {
//            Ingredient.PINEAPPLE -> R.string.ingredient_pineapple
//            Ingredient.MOZZARELLA -> R.string.ingredient_mozzarella
//            Ingredient.PEPERONI -> R.string.ingredient_peperoni
//            Ingredient.GREEN_PEPPER -> R.string.ingredient_green_pepper
//            Ingredient.MUSHROOMS -> R.string.ingredient_mushrooms
//            Ingredient.BASIL -> R.string.ingredient_basil
//            Ingredient.CHEDDAR -> R.string.ingredient_cheddar
//            Ingredient.PARMESAN -> R.string.ingredient_parmesan
//            Ingredient.FETA -> R.string.ingredient_feta
//            Ingredient.HAM -> R.string.ingredient_ham
//            Ingredient.PICKLE -> R.string.ingredient_pickle
//            Ingredient.TOMATO -> R.string.ingredient_tomato
//            Ingredient.BACON -> R.string.ingredient_bacon
//            Ingredient.ONION -> R.string.ingredient_onion
//            Ingredient.CHILE -> R.string.ingredient_chile
//            Ingredient.SHRIMPS -> R.string.ingredient_shrimps
//            Ingredient.CHICKEN_FILLET -> R.string.ingredient_chicken_fillet
//            Ingredient.MEATBALLS -> R.string.ingredient_meatballs
////            else -> ingredient.name.toString()
//        }
//        val name = stringResource(nameId)
//        "$name: ${ingredient.cost}₽"
//    }
//}
