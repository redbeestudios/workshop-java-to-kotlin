package com.nerdearla.workshop.payment.service.model

import com.nerdearla.workshop.authorization.PaymentAuthorization
import com.nerdearla.workshop.operation.PaymentOperation

data class Payment(
    val paymentId: String,
    val authorizationId: String,
    val traceNumber: String,
    val qrId: String,
    val paymentMethodId: String,
    val amount: Double,
    val buyerId: String,
    val sellerId: String
) {
    companion object {
        fun buildFrom(operation: PaymentOperation, authorization: PaymentAuthorization) =
            Payment(
                paymentId = operation.paymentId!!,
                authorizationId = authorization.id,
                traceNumber = operation.paymentRequest.terminalData.traceNumber,
                qrId = operation.qr!!.id,
                paymentMethodId = operation.paymentMethod!!.id,
                buyerId = operation.buyer!!.id,
                sellerId = operation.seller!!.id,
                amount = operation.paymentRequest.amount,
            )
    }
}
