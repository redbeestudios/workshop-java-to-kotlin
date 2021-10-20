package com.nerdearla.workshop.user.seller.client

import com.nerdearla.workshop.shared.client.get
import com.nerdearla.workshop.shared.utils.CompanionLogger
import com.nerdearla.workshop.user.seller.Seller
import com.nerdearla.workshop.user.seller.error.SellerRetrievingError
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class SellerClient(
    private val client: WebClient
) {

    fun getBy(id: String): Seller =
        client.get<Seller>("/sellers/{sellerId}", id, handler = ::handleError)
            .log { info("seller found: {}", it) }

    private fun handleError(response: ClientResponse): Mono<Throwable> =
        Mono.error<Throwable>(SellerRetrievingError())
            .log { error("Error while communicating with seller service, {}", response) }

    companion object : CompanionLogger()
}
