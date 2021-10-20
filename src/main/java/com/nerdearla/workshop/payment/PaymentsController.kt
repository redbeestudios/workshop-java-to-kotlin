package com.nerdearla.workshop.payment

import com.nerdearla.workshop.operation.PaymentOperation
import com.nerdearla.workshop.payment.PaymentsController
import com.nerdearla.workshop.payment.mapper.PaymentResponseMapper
import com.nerdearla.workshop.payment.service.PaymentService
import com.nerdearla.workshop.payment.service.model.Payment
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("payments")
class PaymentsController(
    private val paymentsService: PaymentService,
    private val paymentResponseMapper: PaymentResponseMapper
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun processPayment(@RequestBody paymentRequest: @Valid PaymentRequest): PaymentResponse {
        val operation = PaymentOperation(paymentRequest)
        return mapToResponse(process(operation))
    }

    private fun process(operation: PaymentOperation): Payment {
        val payment = paymentsService.processPayment(operation)
        LOGGER.info("payment processed {}", payment.toString())
        return payment
    }

    private fun mapToResponse(payment: Payment): PaymentResponse {
        val paymentResponse = paymentResponseMapper.map(payment)
        LOGGER.info("payment response {}", payment)
        return paymentResponse
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(PaymentsController::class.java)
    }
}
