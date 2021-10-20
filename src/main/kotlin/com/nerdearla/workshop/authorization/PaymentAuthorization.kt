package com.nerdearla.workshop.authorization

data class PaymentAuthorization(
    val id: String,
    val traceNumber: String,
    val status: String
)
