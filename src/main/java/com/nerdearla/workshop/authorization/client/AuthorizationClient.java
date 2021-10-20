package com.nerdearla.workshop.authorization.client;

import com.nerdearla.workshop.authorization.error.PaymentAuthorizationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class AuthorizationClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationClient.class);
    private final WebClient webClient;

    public AuthorizationClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public PaymentAuthorizationResponse authorize(PaymentAuthorizationRequest paymentAuthorizationRequest) {
        final PaymentAuthorizationResponse response = webClient
                .post()
                .uri("/authorizations")
                .body(Mono.just(paymentAuthorizationRequest), PaymentAuthorizationRequest.class)
                .retrieve()
                .onStatus(HttpStatus::isError, this::handleError)
                .bodyToMono(PaymentAuthorizationResponse.class)
                .block();
        LOGGER.info("payment authorized: {}", response);
        return response;
    }

    private Mono<Throwable> handleError(ClientResponse response) {
        LOGGER.error("Error while communicating with authorization service, {}", response);
        return Mono.error(new PaymentAuthorizationError());
    }
}
