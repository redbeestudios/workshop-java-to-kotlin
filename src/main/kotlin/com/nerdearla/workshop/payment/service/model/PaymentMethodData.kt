package com.nerdearla.workshop.payment.service.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class PaymentMethodData(
    @field:NotBlank(message = "payment_method_data.token must not be blank")
    val token: String = "",

    @field:NotBlank(message = "payment_method_data.security_code must be a number")
    @field:Pattern(regexp = "^[0-9]*\$", message = "payment_method_data.security_code must be a number")
    val securityCode: String = ""
)
