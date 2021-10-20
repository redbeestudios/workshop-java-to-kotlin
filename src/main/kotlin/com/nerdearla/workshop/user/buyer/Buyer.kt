package com.nerdearla.workshop.user.buyer

import com.nerdearla.workshop.user.shared.Address

data class Buyer(
    val id: String,
    val identification: String,
    val enabled: Boolean,
    val name: String,
    val lastName: String,
    val email: String,
    val dateOfBirth: String,
    val address: Address?
)


