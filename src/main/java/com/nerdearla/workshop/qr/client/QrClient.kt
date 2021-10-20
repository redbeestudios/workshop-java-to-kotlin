package com.nerdearla.workshop.qr.client

import com.nerdearla.workshop.qr.QR
import com.nerdearla.workshop.qr.error.QrRetrievingError
import com.nerdearla.workshop.shared.client.get
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class QrClient(
    private val client: WebClient
) {

    fun getBy(id: String): QR =
        client.get<QR>("/qrs/{qrId}", id, handler = ::handleError)
            .log { info("qr found: {}", it) }

    private fun handleError(response: ClientResponse): Mono<Throwable> =
        Mono.error<Throwable>(QrRetrievingError())
            .log { error("Error while communicating with qr service, {}", response) }

    companion object : CompanionLogger()
}
