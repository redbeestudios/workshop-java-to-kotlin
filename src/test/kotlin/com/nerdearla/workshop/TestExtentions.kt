package com.nerdearla.workshop

fun <T> given(message: String = "", block: () -> T): T = block()
fun <T> `when`(message: String = "", block: () -> T): T = block()
fun <T> and(message: String = "", block: () -> T): T = block()
fun <T> then(message: String = "", block: () -> T): T = block()
