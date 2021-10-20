package com.nerdearla.workshop.user.buyer.client;

import com.nerdearla.workshop.user.buyer.Buyer;
import com.nerdearla.workshop.user.buyer.error.BuyerRetrievingError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class BuyerClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuyerClient.class);
    private final WebClient webClient;

    public BuyerClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Buyer getById(String id) {
        Buyer buyer = webClient
                .get()
                .uri("/buyers/{id}", id)
                .retrieve()
                .onStatus(HttpStatus::isError, this::handleError)
                .bodyToMono(Buyer.class)
                .block();
        LOGGER.info("buyer found: {}", buyer);
        return buyer;
    }

    private Mono<Throwable> handleError(ClientResponse response) {
        LOGGER.error("Error while communicating with buyer service, {}", response);
        return Mono.error(new BuyerRetrievingError());
    }
}
