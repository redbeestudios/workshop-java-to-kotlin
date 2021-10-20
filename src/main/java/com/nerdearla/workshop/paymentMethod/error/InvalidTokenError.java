package com.nerdearla.workshop.paymentMethod.error;

import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

public class InvalidTokenError extends ResponseStatusException {

    public InvalidTokenError() {
        super(UNPROCESSABLE_ENTITY, "invalid token");
    }
}
