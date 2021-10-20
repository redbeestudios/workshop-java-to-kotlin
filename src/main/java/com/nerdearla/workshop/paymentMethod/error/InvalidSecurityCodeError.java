package com.nerdearla.workshop.paymentMethod.error;

import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

public class InvalidSecurityCodeError extends ResponseStatusException {

    public InvalidSecurityCodeError() {
        super(UNPROCESSABLE_ENTITY, "invalid security code");
    }
}
