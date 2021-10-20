package com.nerdearla.workshop.user.seller

import com.nerdearla.workshop.user.shared.Address

data class Seller(
    val id: String,
    val identification: String,
    val enabled: Boolean,
    val name: String,
    val email: String,
    val address: Address
)

