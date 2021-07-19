/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.crashreporting.napier

import io.github.aakira.napier.Antilog
import io.github.aakira.napier.Napier
import dev.icerock.moko.crashreporting.core.CrashReportingCore
import dev.icerock.moko.crashreporting.core.ExceptionLogger

class CrashReportingAntilog(private val exceptionLogger: ExceptionLogger) : Antilog() {
    override fun performLog(
        priority: Napier.Level,
        tag: String?,
        throwable: Throwable?,
        message: String?
    ) {
        exceptionLogger.log(
            CrashReportingCore.getLogText(
                logLevel = priority.name,
                tag = tag,
                message = message
            )
        )

        throwable?.let {
            exceptionLogger.recordException(it)
        }
    }
}
