package com.nerdearla.workshop.paymentMethod

import com.nerdearla.workshop.payment.service.model.PaymentMethodData
import com.nerdearla.workshop.paymentMethod.client.PaymentMethodClient
import com.nerdearla.workshop.paymentMethod.validator.PaymentMethodValidator
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Service

@Service
class PaymentMethodService(
    private val client: PaymentMethodClient,
    private val validator: PaymentMethodValidator
) {
    fun getBy(buyerId: String, paymentMethodData: PaymentMethodData): BuyerPaymentMethod =
        doGet(buyerId, paymentMethodData.token)
            .also { it.validateAgainst(paymentMethodData) }

    private fun doGet(buyerId: String, token: String) =
        client.getBy(buyerId, token)
            .log { info("payment method found: {}", it) }

    private fun BuyerPaymentMethod.validateAgainst(paymentMethodData: PaymentMethodData) =
        validator.validate(this, paymentMethodData)
            .log { info("payment {} validated", id) }

    companion object : CompanionLogger()
}


