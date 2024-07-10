package com.example.shift_pizza_2024.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shift_pizza_2024.R

@Composable
fun HistoryScreen(
    historyViewModel: HistoryViewModel,
    onItemSelected: (loanId: Long) -> Unit,
) {
    val historyState by historyViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        historyViewModel.loadPizzas()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 8.dp),
            text = stringResource(id = R.string.history_title),
            style = MaterialTheme.typography.titleLarge,
        )

        when (val state = historyState) {
            is HistoryState.Initial,
            is HistoryState.Loading -> LoadingComponent()

            is HistoryState.Failure -> ErrorComponent(
                message = state.message ?: stringResource(id = R.string.error_unknown_error),
                onRetry = { historyViewModel.loadPizzas() },
            )

            is HistoryState.Content -> ContentComponent(
                pizza = state.pizzas,
                onItemClicked = onItemSelected,
            )
        }
    }
}
