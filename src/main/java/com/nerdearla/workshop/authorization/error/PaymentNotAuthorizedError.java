package com.nerdearla.workshop.authorization.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

public class PaymentNotAuthorizedError extends ResponseStatusException {

    public PaymentNotAuthorizedError() {
        super(UNPROCESSABLE_ENTITY, "payment not authorized");
    }
}
