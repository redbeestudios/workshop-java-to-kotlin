package com.nerdearla.workshop.payment.service.model

data class PaymentMethodData(
    val token: String,
    val securityCode: String
)
