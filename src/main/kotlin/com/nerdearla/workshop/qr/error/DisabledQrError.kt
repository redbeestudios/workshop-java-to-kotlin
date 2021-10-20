package com.nerdearla.workshop.qr.error

import org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import org.springframework.web.server.ResponseStatusException

class DisabledQrError :
    ResponseStatusException(UNPROCESSABLE_ENTITY, "qr disabled")
