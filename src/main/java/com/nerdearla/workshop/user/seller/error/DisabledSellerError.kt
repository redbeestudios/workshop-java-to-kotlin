package com.nerdearla.workshop.user.seller.error

import org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import org.springframework.web.server.ResponseStatusException

class DisabledSellerError:
    ResponseStatusException(UNPROCESSABLE_ENTITY, "seller disabled")

