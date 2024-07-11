package com.example.shift_pizza_2024.shopping_cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shift_pizza_2024.R
import com.example.shift_pizza_2024.data.pizza.Pizza
import com.example.shift_pizza_2024.history.ErrorComponent

@Composable
fun ShopScreen(pizza: Pizza) {
    var shopState by remember { mutableStateOf<ShopState>(ShopState.Initial) }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 8.dp),
            text = stringResource(id = R.string.shopping_cart),
            style = MaterialTheme.typography.titleLarge,
        )

        when (val state = shopState) {
            is ShopState.Initial,
            is ShopState.Loading -> LoadingComponent()

            is ShopState.Failure -> ErrorComponent(
                message = state.message ?: stringResource(id = R.string.error_unknown_error),
                onRetry = {
//                    scope.loadPizza(pizzaId, repository, setDetailsState = { shopState = it })
                }
            )

            is ShopState.Content -> ContentComponent(
                pizza = pizza,
            )
        }
    }
}
