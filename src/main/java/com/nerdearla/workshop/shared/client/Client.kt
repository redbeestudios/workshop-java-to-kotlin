package com.nerdearla.workshop.shared.client

import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

inline fun <reified T> WebClient.get(
    uri: String,
    vararg uriArgs: String,
    crossinline handler: (response: ClientResponse) -> Mono<Throwable>
): T =
    this.get()
        .uri(uri, *uriArgs)
        .retrieve()
        .onStatus(HttpStatus::isError) { response -> handler(response) }
        .bodyToMono(T::class.java)
        .block()!!

inline fun <reified T, reified R> WebClient.post(
    uri: String,
    request: R,
    vararg uriArgs: String,
    crossinline handler: (response: ClientResponse) -> Mono<Throwable>
): T =
    this.post()
        .uri(uri, *uriArgs)
        .body(Mono.just(request!!), R::class.java)
        .retrieve()
        .onStatus(HttpStatus::isError) { response -> handler(response) }
        .bodyToMono(T::class.java)
        .block()!!
