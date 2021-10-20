package com.nerdearla.workshop.operation

import com.nerdearla.workshop.payment.service.model.PaymentMethodData
import com.nerdearla.workshop.payment.service.model.TerminalData
import com.nerdearla.workshop.paymentMethod.BuyerPaymentMethod
import com.nerdearla.workshop.qr.QR
import com.nerdearla.workshop.user.buyer.Buyer
import com.nerdearla.workshop.user.seller.Seller

data class InitialOperation(
    val qrId: String,
    val buyerId: String,
    val identification: String,
    val sellerId: String,
    val amount: Double,
    val installments: Int = 1,
    val terminalData: TerminalData,
    val paymentMethodData: PaymentMethodData
)

data class ExpandedOperation(
    val paymentId: String,
    val qr: QR,
    val buyerPaymentMethod: BuyerPaymentMethod,
    val amount: Double,
    val installments: Int,
    val seller: Seller,
    val buyer: Buyer,
    val terminalData: TerminalData
)

data class AuthorizedOperation(
    val operation: ExpandedOperation,
    val authorizationId: String
)
