package com.nerdearla.workshop.paymentMethod.client

import com.nerdearla.workshop.paymentMethod.BuyerPaymentMethod
import com.nerdearla.workshop.paymentMethod.error.PaymentMethodRetrievingError
import com.nerdearla.workshop.shared.client.get
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class PaymentMethodClient(
    private val client: WebClient
) {

    fun getBy(buyerId: String, token: String): BuyerPaymentMethod =
        client.get<BuyerPaymentMethod>(
            "/buyers/{buyerId}/paymentMethods/token/{paymentMethodToken}", buyerId, token,
            handler = ::handleError
        )
            .log { info("payment method found: {}", it) }

    private fun handleError(response: ClientResponse): Mono<Throwable> =
        Mono.error<Throwable>(PaymentMethodRetrievingError())
            .log { error("Error while communicating with payment method service, {}", response) }

    companion object : CompanionLogger()
}
