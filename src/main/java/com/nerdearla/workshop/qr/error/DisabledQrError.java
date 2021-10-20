package com.nerdearla.workshop.qr.error;

import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

public class DisabledQrError extends ResponseStatusException {

    public DisabledQrError() {
        super(UNPROCESSABLE_ENTITY, "qr disabled");
    }
}
