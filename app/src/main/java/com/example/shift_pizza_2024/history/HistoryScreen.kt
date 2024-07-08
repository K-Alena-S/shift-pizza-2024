package com.example.shift_pizza_2024.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.shift_pizza_2024.R
import com.example.shift_pizza_2024.network.LoanRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HistoryScreen(
    repository: LoanRepository,
    onItemSelected: (loanId: Long) -> Unit,
) {
    val scope = rememberCoroutineScope()
    var historyState by remember { mutableStateOf<HistoryState>(HistoryState.Initial) }

    LaunchedEffect(Unit) {
        loadLoans(repository, setHistoryState = { historyState = it })
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = stringResource(id = R.string.history_title), modifier = Modifier.fillMaxWidth())

        when (val state = historyState) {
            is HistoryState.Initial,
            is HistoryState.Loading -> LoadingComponent()

            is HistoryState.Failure -> ErrorComponent(
                message = state.message ?: stringResource(id = R.string.error_unknown_error),
                onRetry = {
                    scope.loadLoans(repository, setHistoryState = { historyState = it })
                }
            )

            is HistoryState.Content -> ContentComponent(
                loans = state.loans,
                onItemClicked = onItemSelected,
            )
        }
    }
}

private fun CoroutineScope.loadLoans(
    repository: LoanRepository,
    setHistoryState: (HistoryState) -> Unit,
) {
    launch {
        setHistoryState(HistoryState.Loading)

        try {
            val loans = repository.getCatalog()
            setHistoryState(HistoryState.Content(loans))
        } catch (ce: CancellationException) {
            throw ce
        } catch (ex: Exception) {
            setHistoryState(HistoryState.Failure(ex.message))
        }
    }
}