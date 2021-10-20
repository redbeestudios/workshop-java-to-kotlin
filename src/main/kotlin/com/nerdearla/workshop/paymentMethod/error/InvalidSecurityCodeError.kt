package com.nerdearla.workshop.paymentMethod.error

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class InvalidSecurityCodeError :
    ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "invalid security code")
