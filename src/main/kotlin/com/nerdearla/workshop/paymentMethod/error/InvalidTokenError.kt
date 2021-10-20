package com.nerdearla.workshop.paymentMethod.error

import org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import org.springframework.web.server.ResponseStatusException

class InvalidTokenError :
    ResponseStatusException(UNPROCESSABLE_ENTITY, "invalid token")
