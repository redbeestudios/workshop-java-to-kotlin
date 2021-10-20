package com.nerdearla.workshop.qr.error

import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.web.server.ResponseStatusException

class QrRetrievingError :
    ResponseStatusException(INTERNAL_SERVER_ERROR, "error while retrieving qr")
