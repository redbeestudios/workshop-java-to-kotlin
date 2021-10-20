package com.nerdearla.workshop.payment

import com.nerdearla.workshop.operation.InitialOperation
import com.nerdearla.workshop.payment.mapper.PaymentResponseMapper
import com.nerdearla.workshop.payment.service.PaymentService
import com.nerdearla.workshop.payment.service.model.Payment
import com.nerdearla.workshop.shared.utils.CompanionLogger
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
    fun processPayment(@RequestBody @Valid paymentRequest: PaymentRequest): PaymentResponse =
        paymentRequest
            .toOperation()
            .process()
            .toResponse()

    private fun PaymentRequest.toOperation() =
        InitialOperation(
            amount = amount,
            buyerId = buyerId,
            paymentMethodData = paymentMethodData,
            qrId = qrId,
            sellerId = sellerId,
            terminalData = terminalData,
            identification = buyerIdentification,
        )

    private fun InitialOperation.process() =
        paymentsService.processPayment(this)
            .log { info("payment processed: {}", it) }

    private fun Payment.toResponse() =
        paymentResponseMapper.map(this)
            .log { info("payment response {}", it) }

    companion object : CompanionLogger()
}
