package com.nerdearla.workshop.authorization.error

import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.web.server.ResponseStatusException

class AuthorizationError :
    ResponseStatusException(INTERNAL_SERVER_ERROR, "Error while authorizing operation")
