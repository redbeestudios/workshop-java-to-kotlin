package com.nerdearla.workshop.user.seller.client;

import com.nerdearla.workshop.user.seller.Seller;
import com.nerdearla.workshop.user.seller.error.SellerRetrievingError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class SellerClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(SellerClient.class);
    private final WebClient webClient;

    public SellerClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Seller getById(String id) {
        final Seller seller = webClient
                .get()
                .uri("/sellers/{sellerId}", id)
                .retrieve()
                .onStatus(HttpStatus::isError, this::handleError)
                .bodyToMono(Seller.class)
                .block();
        LOGGER.info("seller found: {}", seller);
        return seller;
    }

    private Mono<Throwable> handleError(ClientResponse response) {
        LOGGER.error("Error while communicating with seller service, {}", response);
        return Mono.error(new SellerRetrievingError());
    }
}
