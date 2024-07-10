package com.example.shift_pizza_2024.data.payment

data class CreatePizzaPaymentDto(
    val receiverAddress: ReceiverAddress,
    val person: Person,
    val debitCard: DebitCard,
    val pizzas: CreatePizzaPaymentPizzaDto
)
