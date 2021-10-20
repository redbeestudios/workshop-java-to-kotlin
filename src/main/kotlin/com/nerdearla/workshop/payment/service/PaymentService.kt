package com.nerdearla.workshop.payment.service

import com.nerdearla.workshop.authorization.GatewayService
import com.nerdearla.workshop.operation.AuthorizedOperation
import com.nerdearla.workshop.operation.ExpandedOperation
import com.nerdearla.workshop.operation.EntityProviderAdapter
import com.nerdearla.workshop.operation.InitialOperation
import com.nerdearla.workshop.payment.repository.PaymentRepository
import com.nerdearla.workshop.payment.service.model.Payment
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val entityProviderAdapter: EntityProviderAdapter,
    private val gatewayService: GatewayService,
    private val paymentRepository: PaymentRepository
) {

    fun processPayment(initialOperation: InitialOperation) =
        initialOperation
            .expandEntities()
            .authorize()
            .toPayment()
            .also { save(it) }

    private fun InitialOperation.expandEntities() =
        entityProviderAdapter.provide {
            ExpandedOperation(
                paymentId = provideId(),
                qr = qrId.provideQr(),
                buyerPaymentMethod = buyerId.providerPaymentMethod(paymentMethodData),
                seller = sellerId.provideSeller(),
                buyer = buyerId.provideBuyer(),
                terminalData = terminalData,
                amount = amount,
                installments = installments
            )
        }
            .log { info("operation expanded {}", it) }

    private fun ExpandedOperation.authorize() =
        gatewayService.authorize(this)
            .log { info("authorization response: {}", it) }
            .let { AuthorizedOperation(this, it.id) }

    private fun AuthorizedOperation.toPayment() =
        Payment(
            id = operation.paymentId,
            amount = operation.amount,
            authorizationId = authorizationId,
            buyerId = operation.buyer.id,
            sellerId = operation.seller.id,
            paymentMethodId = operation.buyerPaymentMethod.id,
            qrId = operation.qr.id,
        )

    private fun save(payment: Payment) =
        paymentRepository.save(payment)
            .log { info("payment {} saved", payment.id) }

    companion object : CompanionLogger()
}
