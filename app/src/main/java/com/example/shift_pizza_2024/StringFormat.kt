package com.example.shift_pizza_2024

import com.example.shift_pizza_2024.data.LoanStatus
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import java.text.NumberFormat
import java.util.Locale

@Composable
fun formatAmountText(amount: Long): String {
    val numberFormatter = NumberFormat.getNumberInstance(Locale.getDefault())
    return numberFormatter.format(amount)
}

@Composable
fun formatLoanStatus(status: LoanStatus): String =
    when (status) {
        LoanStatus.APPROVED   -> stringResource(R.string.approved)
        LoanStatus.REGISTERED -> stringResource(R.string.registered)
        LoanStatus.REJECTED   -> stringResource(R.string.rejected)
    }