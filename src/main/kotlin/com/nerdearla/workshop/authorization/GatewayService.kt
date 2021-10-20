package com.nerdearla.workshop.authorization

import com.nerdearla.workshop.authorization.client.GatewayClient
import com.nerdearla.workshop.authorization.client.model.PaymentAuthorizationRequest
import com.nerdearla.workshop.authorization.client.model.PaymentAuthorizationResponse
import com.nerdearla.workshop.authorization.validator.AuthorizationValidator
import com.nerdearla.workshop.operation.PaymentOperation
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Service

@Service
class GatewayService(
    private val validator: AuthorizationValidator,
    private val client: GatewayClient
) {

    fun authorize(operation: PaymentOperation) =
        operation
            .authorize()
            .toPaymentAuthorization()
            .also { it.validate() }

    private fun PaymentOperation.authorize() =
        client.authorize(toRequest())
            .log { info("payment authorization response obtained") }

    private fun PaymentOperation.toRequest() =
        PaymentAuthorizationRequest(
            paymentMethodToken = paymentMethod!!.token,
            paymentMethodSecurityCode = paymentMethod!!.securityCode,
            holderIdentification = buyer!!.identification,
            establishmentId = paymentRequest.terminalData!!.establishmentId,
            terminalNumber = paymentRequest.terminalData.terminalNumber,
            ticketNumber = paymentRequest.terminalData.ticketNumber,
            traceNumber = paymentRequest.terminalData.traceNumber,
            transactionDatetime = paymentRequest.terminalData.transactionDatetime
        )

    private fun PaymentAuthorizationResponse.toPaymentAuthorization() =
        PaymentAuthorization(id, traceNumber, status)

    private fun PaymentAuthorization.validate() =
        validator.validate(this)
            .log { info("payment authorization validated") }

    companion object : CompanionLogger()
}
