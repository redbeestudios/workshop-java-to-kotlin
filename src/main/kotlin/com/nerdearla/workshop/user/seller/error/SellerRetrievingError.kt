package com.nerdearla.workshop.user.seller.error

import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.web.server.ResponseStatusException

class SellerRetrievingError :
    ResponseStatusException(INTERNAL_SERVER_ERROR, "error while retrieving seller")
