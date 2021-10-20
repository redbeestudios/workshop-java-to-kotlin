package com.nerdearla.workshop.operation

import com.nerdearla.workshop.payment.PaymentRequest
import com.nerdearla.workshop.paymentMethod.BuyerPaymentMethod
import com.nerdearla.workshop.qr.QR
import com.nerdearla.workshop.user.buyer.Buyer
import com.nerdearla.workshop.user.seller.Seller

data class PaymentOperation(
    val paymentRequest: PaymentRequest
) {
    var paymentId: String? = null
    var qr: QR? = null
    var buyer: Buyer? = null
    var seller: Seller? = null
    var paymentMethod: BuyerPaymentMethod? = null
}
