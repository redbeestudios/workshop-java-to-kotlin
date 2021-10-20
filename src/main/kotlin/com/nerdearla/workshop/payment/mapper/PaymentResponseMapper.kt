package com.nerdearla.workshop.payment.mapper

import com.nerdearla.workshop.payment.service.model.Payment
import com.nerdearla.workshop.payment.PaymentResponse
import org.springframework.stereotype.Component

@Component
class PaymentResponseMapper {
    fun map(payment: Payment): PaymentResponse =
        with(payment) {
            PaymentResponse(
                paymentId = id
            )
        }

}
