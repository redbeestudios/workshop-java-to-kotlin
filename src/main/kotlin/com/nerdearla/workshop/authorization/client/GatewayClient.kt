package com.nerdearla.workshop.authorization.client

import com.nerdearla.workshop.authorization.client.model.PaymentAuthorizationRequest
import com.nerdearla.workshop.authorization.client.model.PaymentAuthorizationResponse
import com.nerdearla.workshop.authorization.error.AuthorizationError
import com.nerdearla.workshop.shared.client.post
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class GatewayClient(
    private val client: WebClient
) {

    fun authorize(request: PaymentAuthorizationRequest) =
        client.post<PaymentAuthorizationResponse, PaymentAuthorizationRequest>(
             "/authorizations",
            request,
            handler = ::handleError
        )
            .log { info("authorization done: {}", it) }

    private fun handleError(response: ClientResponse): Mono<Throwable> =
        Mono.error<Throwable>(AuthorizationError())
            .log { error("Error while communicating with authorization service, {}", response) }

    companion object : CompanionLogger()
}
