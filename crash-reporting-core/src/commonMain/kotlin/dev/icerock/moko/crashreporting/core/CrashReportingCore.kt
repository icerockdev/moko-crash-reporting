/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.crashreporting.core

object CrashReportingCore {

    fun getLogText(logLevel: String? = null, tag: String? = null, message: String? = null): String {

        return buildString {
            logLevel?.let {
                append(it)
                append(": ")
            }

            tag?.let {
                append(it)
                append(" - ")
            }
            message?.let { append(message) }
        }
    }

    fun getExceptionName(throwable: Throwable): String {
        return throwable::class.simpleName ?: "Unknown"
    }
}
