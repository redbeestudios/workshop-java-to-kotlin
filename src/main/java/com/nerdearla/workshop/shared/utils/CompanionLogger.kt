package com.nerdearla.workshop.shared.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class CompanionLogger {

    @Suppress("JAVA_CLASS_ON_COMPANION")
    val log: Logger by lazy { LoggerFactory.getLogger(javaClass.enclosingClass) }

    inline fun <T> T.log(block: Logger.(T) -> Unit): T =
        also { block(log, this) }

    infix fun Logger.trace(message: String) = log.trace(message)
    infix fun Logger.debug(message: String) = log.debug(message)
    infix fun Logger.info(message: String) = log.info(message)
    infix fun Logger.warn(message: String) = log.warn(message)
    infix fun Logger.error(message: String) = log.error(message)

}
