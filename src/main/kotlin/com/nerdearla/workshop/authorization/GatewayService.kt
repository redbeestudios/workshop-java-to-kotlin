package com.nerdearla.workshop.authorization

import com.nerdearla.workshop.authorization.client.GatewayClient
import com.nerdearla.workshop.authorization.client.model.PaymentAuthorizationRequest
import com.nerdearla.workshop.authorization.client.model.PaymentAuthorizationResponse
import com.nerdearla.workshop.authorization.validator.AuthorizationValidator
import com.nerdearla.workshop.operation.ExpandedOperation
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Service

@Service
class GatewayService(
    private val validator: AuthorizationValidator,
    private val client: GatewayClient
) {

    fun authorize(operation: ExpandedOperation) =
        operation
            .authorize()
            .toPaymentAuthorization()
            .also { it.validate() }

    private fun ExpandedOperation.authorize() =
        client.authorize(toRequest())
            .log { info("payment authorization response obtained") }

    private fun ExpandedOperation.toRequest() =
        PaymentAuthorizationRequest(
            paymentMethodToken = buyerPaymentMethod.token,
            paymentMethodSecurityCode = buyerPaymentMethod.securityCode,
            holderIdentification = buyer.identification,
            establishmentId = terminalData.establishmentId,
            terminalNumber = terminalData.terminalNumber,
            ticketNumber = terminalData.ticketNumber,
            traceNumber = terminalData.traceNumber,
            transactionDatetime = terminalData.transactionDatetime
        )

    private fun PaymentAuthorizationResponse.toPaymentAuthorization() =
        PaymentAuthorization(id, traceNumber, status)

    private fun PaymentAuthorization.validate() =
        validator.validate(this)
            .log { info("payment authorization validated") }

    companion object : CompanionLogger()
}
