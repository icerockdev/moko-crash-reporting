/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package com.icerockdev.library

import com.github.aakira.napier.Napier
import dev.icerock.moko.crashReporting.CrashlyticsAntilog
import dev.icerock.moko.crashReporting.CrashlyticsCore
import dev.icerock.moko.crashReporting.CrashlyticsLogger

class Testing(crashlyticsLogger: CrashlyticsLogger) {

    private val userId = "test_user"
    private val customValue = "test_custom_value"

    private val crashlyticsCore = CrashlyticsCore(crashlyticsLogger)

    init {
        // use it only for prod, to not send logs to crashlytics while debug - use DebugAntilog(defaultTag: "some tag")
        Napier.base(CrashlyticsAntilog(core = crashlyticsCore))
    }

    fun setUserId() {
        crashlyticsCore.setUserId(userId)
    }

    fun setCustomValue() {
        crashlyticsCore.setCustomValue(value = customValue, forKey = "customKey")
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
