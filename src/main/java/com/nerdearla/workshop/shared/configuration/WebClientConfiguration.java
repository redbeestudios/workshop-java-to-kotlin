package com.nerdearla.workshop.shared.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    @Value("${api.baseUrl}")
    private String baseUrl;

    @Value("${api.headers.x-api-key}")
    private String apiKey;

    @Bean
    public WebClient webClient() {
        return WebClient
                .builder()
                .baseUrl(baseUrl)
                .defaultHeaders( httpHeaders -> httpHeaders.set("x-api-key", apiKey))
                .build();
    }
}
