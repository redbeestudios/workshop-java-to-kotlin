package com.nerdearla.workshop.user.seller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SellerRetrievingError extends ResponseStatusException {

    public SellerRetrievingError() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "error while retrieving seller");
    }
}
