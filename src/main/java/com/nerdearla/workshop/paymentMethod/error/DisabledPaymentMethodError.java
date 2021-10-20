package com.nerdearla.workshop.paymentMethod.error;

import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

public class DisabledPaymentMethodError extends ResponseStatusException {

    public DisabledPaymentMethodError() {
        super(UNPROCESSABLE_ENTITY, "payment method disabled");
    }
}
