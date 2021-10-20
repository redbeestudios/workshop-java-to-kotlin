package com.nerdearla.workshop.payment.service

import com.nerdearla.workshop.authorization.GatewayService
import com.nerdearla.workshop.operation.PaymentOperation
import com.nerdearla.workshop.payment.repository.PaymentRepository
import com.nerdearla.workshop.payment.service.model.Payment
import com.nerdearla.workshop.paymentMethod.PaymentMethodService
import com.nerdearla.workshop.qr.QRService
import com.nerdearla.workshop.shared.IdProvider
import com.nerdearla.workshop.user.buyer.BuyerService
import com.nerdearla.workshop.user.seller.SellerService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class PaymentService(
    @Qualifier("paymentIdProvider") private val paymentIdProvider: IdProvider,
    private val paymentMethodService: PaymentMethodService,
    private val authorizationService: GatewayService,
    private val buyerService: BuyerService,
    private val sellerService: SellerService,
    private val paymentRepository: PaymentRepository,
    private val qrService: QRService
) {
    fun processPayment(operation: PaymentOperation): Payment {
        val id = paymentIdProvider.provide()
        operation.paymentId = id
        val qr = qrService.getBy(operation.paymentRequest.qrId)
        operation.qr = qr
        LOGGER.info("qr found: {}", qr.toString())
        val buyer = buyerService.getBy(operation.paymentRequest.buyerId)
        operation.buyer = buyer
        LOGGER.info("buyer found: {}", buyer.toString())
        val buyerPaymentMethod = paymentMethodService.getBy(buyer.id, operation.paymentRequest.paymentMethodData)
        operation.paymentMethod = buyerPaymentMethod
        LOGGER.info("payment method found: {}", buyerPaymentMethod.toString())
        val seller = sellerService.getBy(operation.paymentRequest.sellerId)
        operation.seller = seller
        LOGGER.info("seller found: {}", seller.toString())
        val authorization = authorizationService.authorize(operation)
        LOGGER.info("authorization response: {}", authorization.toString())
        val payment = Payment.buildFrom(operation, authorization)
        paymentRepository.save(payment)
        LOGGER.info("payment {} saved", payment.paymentId)
        return payment
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(PaymentService::class.java)
    }
}
