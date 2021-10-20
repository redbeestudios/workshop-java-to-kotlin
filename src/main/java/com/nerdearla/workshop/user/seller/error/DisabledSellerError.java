package com.nerdearla.workshop.user.seller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DisabledSellerError extends ResponseStatusException {

    public DisabledSellerError() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "seller disabled");
    }
}
