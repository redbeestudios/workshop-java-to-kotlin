package com.nerdearla.workshop.payment.service.model

data class TerminalData(
    val establishmentId: String,
    val terminalNumber: String,
    val traceNumber: String,
    val ticketNumber: String,
    val transactionDatetime: String
)
