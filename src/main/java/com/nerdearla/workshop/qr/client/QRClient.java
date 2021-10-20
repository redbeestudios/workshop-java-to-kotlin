package com.nerdearla.workshop.qr.client;

import com.nerdearla.workshop.qr.QR;
import com.nerdearla.workshop.qr.error.QRRetrievingError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class QRClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(QRClient.class);
    private final WebClient webClient;

    public QRClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public QR getById(String id) {
        QR qr = webClient
                .get()
                .uri("/qrs/{id}", id)
                .retrieve()
                .onStatus(HttpStatus::isError, this::handleError)
                .bodyToMono(QR.class)
                .block();
        LOGGER.info("qr found: {}", qr);
        return qr;
    }

    private Mono<Throwable> handleError(ClientResponse clientResponse) {
        LOGGER.error("Error while communicating with QR service, {}", clientResponse);
        return Mono.error(new QRRetrievingError());
    }
}
