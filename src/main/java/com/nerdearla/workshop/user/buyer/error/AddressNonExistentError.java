package com.nerdearla.workshop.user.buyer.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AddressNonExistentError extends ResponseStatusException {

    public AddressNonExistentError() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "buyer needs to have an address");
    }
}
