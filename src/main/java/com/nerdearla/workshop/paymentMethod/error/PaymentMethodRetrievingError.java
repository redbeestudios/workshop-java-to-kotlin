package com.nerdearla.workshop.paymentMethod.error;

import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class PaymentMethodRetrievingError extends ResponseStatusException {

    public PaymentMethodRetrievingError() {
        super(INTERNAL_SERVER_ERROR, "error while retrieving payment method");
    }
}
