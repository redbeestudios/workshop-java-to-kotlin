package com.nerdearla.workshop.qr.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class QRRetrievingError extends ResponseStatusException {

    public QRRetrievingError() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "error while retrieving qr");
    }
}
