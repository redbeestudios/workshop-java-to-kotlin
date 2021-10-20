package com.nerdearla.workshop.payment.provider;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PaymentIdProvider {
    public String getNext() {
        return UUID.randomUUID().toString();
    }
}
