package com.nerdearla.workshop.user.buyer.error

import org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import org.springframework.web.server.ResponseStatusException

class DisabledBuyerError :
    ResponseStatusException(UNPROCESSABLE_ENTITY, "buyer disabled")

