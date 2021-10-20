package com.nerdearla.workshop.user.buyer.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DisabledBuyerError extends ResponseStatusException {

    public DisabledBuyerError() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "buyer disabled");
    }
}
