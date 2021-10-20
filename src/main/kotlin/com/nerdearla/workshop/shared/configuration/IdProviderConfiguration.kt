package com.nerdearla.workshop.shared.configuration

import com.nerdearla.workshop.shared.IdProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.UUID

@Configuration
class IdProviderConfiguration {

    @Bean("paymentIdProvider")
    fun paymentIdProvider(): IdProvider =
        IdProvider { UUID.randomUUID().toString() }
}
