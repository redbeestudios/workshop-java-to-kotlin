package com.nerdearla.workshop.payment

import com.nerdearla.workshop.payment.service.model.PaymentMethodData
import com.nerdearla.workshop.payment.service.model.TerminalData

data class PaymentRequest(
    val qrId: String,
    val buyerId: String,
    val sellerId: String,
    val amount: Double,
    val installments: Int,
    val terminalData: TerminalData,
    val paymentMethodData: PaymentMethodData
)
