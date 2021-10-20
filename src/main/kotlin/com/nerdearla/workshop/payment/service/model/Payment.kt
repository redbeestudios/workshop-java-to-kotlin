package com.nerdearla.workshop.payment.service.model

data class Payment(
    val id: String,
    val authorizationId: String,
    val qrId: String,
    val paymentMethodId: String,
    val amount: Double,
    val buyerId: String,
    val sellerId: String
)
