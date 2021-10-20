package com.nerdearla.workshop.paymentMethod.client;

import com.nerdearla.workshop.paymentMethod.BuyerPaymentMethod;
import com.nerdearla.workshop.paymentMethod.error.PaymentMethodRetrievingError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PaymentMethodClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentMethodClient.class);
    private final WebClient webClient;

    public PaymentMethodClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public BuyerPaymentMethod get(String buyerId, String token) {
        final BuyerPaymentMethod buyerPaymentMethod = webClient
                .get()
                .uri("/buyers/{buyerId}/paymentMethods/token/{paymentMethodToken}", buyerId, token)
                .retrieve()
                .onStatus(HttpStatus::isError, this::handleError)
                .bodyToMono(BuyerPaymentMethod.class)
                .block();
        LOGGER.info("payment method found: {}", buyerPaymentMethod);
        return buyerPaymentMethod;
    }

    private Mono<Throwable> handleError(ClientResponse clientResponse) {
        LOGGER.error("Error while communicating with paymentMethod service, {}", clientResponse);
        return Mono.error(new PaymentMethodRetrievingError());
    }
}
