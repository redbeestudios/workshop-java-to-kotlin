package com.nerdearla.workshop.shared.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfiguration(
    @Value("\${api.baseUrl}")
    private val baseUrl: String,
    @Value("\${api.headers.x-api-key}")
    private val apiKey: String
) {

    @Bean
    fun webClient(): WebClient =
        WebClient
            .builder()
            .baseUrl(baseUrl)
            .defaultHeaders { header ->
                header.set("x-api-key", apiKey)
            }
            .build()

    @Bean
    fun objectMapper(): ObjectMapper =
        ObjectMapper()
            .registerKotlinModule()
}
