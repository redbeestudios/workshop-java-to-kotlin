package com.nerdearla.workshop.payment.service.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class TerminalData(

    @field:NotBlank(message = "establishment_id must be numeric")
    @field:Pattern(regexp = "^[0-9]*\$", message = "establishment_id must be numeric")
    val establishmentId: String = "",

    @field:NotBlank(message = "terminal_number must be numeric")
    @field:Pattern(regexp = "^[0-9]*\$", message = "terminal_number must be numeric")
    val terminalNumber: String = "",

    @field:NotBlank(message = "trace_number must be numeric")
    @field:Pattern(regexp = "^[0-9]*\$", message = "trace_number must be numeric")
    val traceNumber: String = "",

    @field:NotBlank(message = "ticket_number must be numeric")
    @field:Pattern(regexp = "^[0-9]*\$", message = "ticket_number must be numeric")
    val ticketNumber: String = "",

    @field:NotBlank(message = "transaction_datetime must not be blank")
    val transactionDatetime: String = "",
)
