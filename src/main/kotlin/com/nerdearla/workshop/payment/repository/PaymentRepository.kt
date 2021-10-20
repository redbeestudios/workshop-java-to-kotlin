package com.nerdearla.workshop.payment.repository

import com.nerdearla.workshop.payment.service.model.Payment
import org.springframework.stereotype.Repository

@Repository
class PaymentRepository {
    fun save(payment: Payment?) {}
}
