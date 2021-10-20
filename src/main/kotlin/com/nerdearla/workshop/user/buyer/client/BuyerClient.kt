package com.nerdearla.workshop.user.buyer.client

import com.nerdearla.workshop.shared.client.get
import com.nerdearla.workshop.shared.utils.CompanionLogger
import com.nerdearla.workshop.user.buyer.Buyer
import com.nerdearla.workshop.user.buyer.error.BuyerRetrievingError
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class BuyerClient(
    private val client: WebClient
) {

    fun getBy(id: String): Buyer =
        client.get<Buyer>("/buyers/{buyerId}", id, handler = ::mono)
            .log { info("buyer found: {}", it) }

    private fun mono(response: ClientResponse) = Mono.error<Throwable>(BuyerRetrievingError())
        .log { error("Error while communicating with buyer service, {}", response) }

    companion object : CompanionLogger()
}
