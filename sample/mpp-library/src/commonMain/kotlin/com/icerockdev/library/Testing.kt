/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package com.icerockdev.library

import com.github.aakira.napier.Napier
import dev.icerock.moko.crashreporting.core.ExceptionLogger
import dev.icerock.moko.crashreporting.crashlytics.CrashlyticsLogger
import dev.icerock.moko.crashreporting.crashlytics.NativeCrashliticsLogger
import dev.icerock.moko.crashreporting.napier.CrashReportingAntilog

class Testing(crashlyticsLogger: NativeCrashliticsLogger) {

    private val userId = "test_user"
    private val customValue = "test_custom_value"

    private val logger: ExceptionLogger

    init {
        logger = CrashlyticsLogger(nativeLogger = crashlyticsLogger)
        Napier.base(antilog = CrashReportingAntilog(exceptionLogger = logger))
    }

    fun setUserId() {
        logger.setUserId(userId)
    }

    fun setCustomValue() {
        logger.setCustomValue(customValue, "customValueKey")
    }

    fun logRandomTestMessage() {
        when (listOf("1", "2", "3", "4").random()) {
            "1" -> Napier.d(message = "Hello World")
            "2" -> Napier.i(message = "This is random message", tag = "FYI")
            "3" -> Napier.w(message = "Something goes wrong", tag = "Alarm")
            "4" -> Napier.v(message = "just verbose", tag = "VERBOSE")
        }
    }

    fun logException() {
        try {
            "test".toInt()
        } catch (e: NumberFormatException) {
            Napier.e(message = "test is not a number", tag = "Non fatal", throwable = e)
        }
    }
}
