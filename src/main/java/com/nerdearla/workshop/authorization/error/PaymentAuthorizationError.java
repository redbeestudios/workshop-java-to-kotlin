package com.nerdearla.workshop.authorization.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class PaymentAuthorizationError extends ResponseStatusException {

    public PaymentAuthorizationError() {
        super(INTERNAL_SERVER_ERROR, "Error while authorizing operation");
    }
}
