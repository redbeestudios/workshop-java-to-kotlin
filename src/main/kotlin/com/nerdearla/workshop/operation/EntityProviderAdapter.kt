package com.nerdearla.workshop.operation

import com.nerdearla.workshop.payment.service.model.PaymentMethodData
import com.nerdearla.workshop.paymentMethod.PaymentMethodService
import com.nerdearla.workshop.qr.QRService
import com.nerdearla.workshop.shared.IdProvider
import com.nerdearla.workshop.shared.utils.CompanionLogger
import com.nerdearla.workshop.user.buyer.BuyerService
import com.nerdearla.workshop.user.seller.SellerService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class EntityProviderAdapter(
    @Qualifier("paymentIdProvider")
    private val paymentIdProvider: IdProvider,
    private val paymentMethodService: PaymentMethodService,
    private val buyerService: BuyerService,
    private val sellerService: SellerService,
    private val qrService: QRService
) {

    fun <T> provide(block: EntityProviderAdapter.() -> T): T =
        block(this)

    fun provideId() =
        paymentIdProvider.provide()

    fun String.provideQr() =
        qrService.getBy(this)
            .log { info("qr found: {}", it) }

    fun String.provideBuyer() =
        buyerService.getBy(this)
            .log { info("buyer found: {}", it) }

    fun String.provideSeller() =
        sellerService.getBy(this)
            .log { info("seller found: {}", it) }

    fun String.providerPaymentMethod(data: PaymentMethodData) =
        paymentMethodService.getBy(this, data)
            .log { info("payment method found: {}", it) }

    companion object : CompanionLogger()
}
