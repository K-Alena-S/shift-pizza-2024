package com.example.shift_pizza_2024.history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.shift_pizza_2024.data.Pizza

@Composable
fun ContentComponent(
    loans: List<Pizza>,
    onItemClicked: (loanId: Long) -> Unit,
) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(loans) { loan ->
            LoanItem(
                loan,
                onItemClicked = { onItemClicked(loan.id) }
            )
        }
    }
}

@Composable
private fun LoanItem(
    item: Pizza,
    onItemClicked: () -> Unit,
) {
    Column (
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onItemClicked)
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = item.name)
        }
    }
}
