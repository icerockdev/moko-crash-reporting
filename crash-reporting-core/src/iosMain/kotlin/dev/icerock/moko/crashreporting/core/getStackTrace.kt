/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.crashreporting.core

fun CrashReportingCore.getStackTrace(throwable: Throwable): List<Long> {

    val addresses: List<Long> = throwable.getStackTraceAddresses()

    var index = 0

    val stackTrace = throwable.getStackTrace()
    for (element in stackTrace) {
        if (throwableBoilerplate(element, "Exception") || throwableBoilerplate(element, "Throwable")) {
            index++
        } else {
            break
        }
    }
    return addresses.subList(index, addresses.size)
}

private fun throwableBoilerplate(frameString: String, lookFor: String): Boolean {
    return frameString.contains("kotlin.$lookFor") || frameString.contains("$lookFor.<init>")
}
