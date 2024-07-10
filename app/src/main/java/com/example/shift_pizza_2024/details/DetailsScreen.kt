package com.example.shiftintensivelivecoding.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shift_pizza_2024.R
import com.example.shift_pizza_2024.network.PizzaRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DetailsScreen(pizzaId: Long, repository: PizzaRepository) {
	val scope = rememberCoroutineScope()
	var detailsState by remember { mutableStateOf<DetailsState>(DetailsState.Initial) }

	LaunchedEffect(Unit) {
		loadPizza(pizzaId, repository, setDetailsState = { detailsState = it })
	}

	Column(modifier = Modifier.fillMaxSize()) {
		Text(
			modifier = Modifier
				.fillMaxWidth()
				.padding(vertical = 12.dp, horizontal = 8.dp),
			text = stringResource(id = R.string.details_title),
			style = MaterialTheme.typography.titleLarge,
		)

		when (val state = detailsState) {
			is DetailsState.Initial,
			is DetailsState.Loading -> LoadingComponent()

			is DetailsState.Failure -> ErrorComponent(
				message = state.message ?: stringResource(id = R.string.error_unknown_error),
				onRetry = {
					scope.loadPizza(pizzaId, repository, setDetailsState = { detailsState = it })
				}
			)

			is DetailsState.Content -> ContentComponent(
				pizza = state.pizza,
			)
		}
	}
}

private fun CoroutineScope.loadPizza(
	pizzaId: Long,
	repository: PizzaRepository,
	setDetailsState: (DetailsState) -> Unit,
) {
	launch {
		setDetailsState(DetailsState.Loading)

		try {
			val pizza = repository.getPizza(pizzaId = pizzaId)
			setDetailsState(DetailsState.Content(pizza))
		} catch (ce: CancellationException) {
			throw ce
		} catch (ex: Exception) {
			setDetailsState(DetailsState.Failure(ex.message))
		}
	}
}