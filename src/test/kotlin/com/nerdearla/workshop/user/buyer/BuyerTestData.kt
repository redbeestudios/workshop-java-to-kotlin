package com.nerdearla.workshop.user.buyer

import com.nerdearla.workshop.user.shared.Address

fun aBuyer() =
    Buyer(
        id = "123",
        identification = "40345654",
        enabled = true,
        name = "Juan",
        lastName = "Perez",
        email = "juan.perez@mail.com",
        dateOfBirth = "a date",
        address = Address(
            id = "123",
            city = "Ciudad Autonoma de Buenos Aires",
            country = "Argentina",
            line1 = "Calle Falsa",
            line2 = "123",
            postalCode = "1234",
            state = "Buenos Aires"
        )
    )
