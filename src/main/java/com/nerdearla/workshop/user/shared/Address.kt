package com.nerdearla.workshop.user.shared

data class Address(
    val id: String,
    val city: String,
    val country: String,
    val line1: String,
    val line2: String,
    val postalCode: String,
    val state: String
)
