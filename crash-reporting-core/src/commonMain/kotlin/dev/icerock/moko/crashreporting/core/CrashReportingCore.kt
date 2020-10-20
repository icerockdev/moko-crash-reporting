/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.crashreporting.core

class CrashReportingCore {

    fun getLogText(logLevel: String? = null, tag: String? = null, message: String? = null): String {
        var logText = logLevel?.let { "$it:" }.orEmpty()

        tag?.let { logText = logText.plus(" $tag - ") }
        message?.let { logText = logText.plus(message) }
        return logText
    }

    fun getExceptionName(throwable: Throwable): String? {
        return throwable.noReflectionSimpleName
    }
}
