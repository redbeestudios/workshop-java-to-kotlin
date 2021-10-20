package com.nerdearla.workshop.user.buyer.error

import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.web.server.ResponseStatusException

class BuyerRetrievingError :
    ResponseStatusException(INTERNAL_SERVER_ERROR, "error while retrieving buyer")
