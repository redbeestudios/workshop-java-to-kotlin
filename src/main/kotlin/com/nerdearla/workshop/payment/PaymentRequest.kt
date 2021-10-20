package com.nerdearla.workshop.payment

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.nerdearla.workshop.payment.service.model.PaymentMethodData
import com.nerdearla.workshop.payment.service.model.TerminalData
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Positive

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class PaymentRequest(

    @field:NotBlank(message = "qr_id must be numeric")
    @field:Pattern(regexp = "^[0-9]*\$", message = "qr_id must be numeric")
    val qrId: String = "",

    @field:NotBlank(message = "buyer_identification must be numeric")
    @field:Pattern(regexp = "^[0-9]*\$", message = "buyer_identification must be numeric")
    val buyerIdentification: String = "",

    @field:NotBlank(message = "buyer_id must be numeric")
    @field:Pattern(regexp = "^[0-9]*\$", message = "buyer_id must be numeric")
    val buyerId: String = "",

    @field:NotBlank(message = "seller_id must be numeric")
    @field:Pattern(regexp = "^[0-9]*\$", message = "seller_id must be numeric")
    val sellerId: String = "",

    @field:Min(1, message = "amount must be at least 1")
    val amount: Double = 0.0,

    @field:Positive(message = "installment must be positive")
    val installments: Int = 1,

    @field:Valid
    val terminalData: TerminalData = TerminalData(),

    @field:Valid
    val paymentMethodData: PaymentMethodData = PaymentMethodData()
)
