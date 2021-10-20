package com.nerdearla.workshop.authorization.client.model

class PaymentAuthorizationResponse(
    val id: String,
    val traceNumber: String,
    val status: String,
    val timestamp: String? = null
)
