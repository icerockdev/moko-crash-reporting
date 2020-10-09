/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.crashreporting.crashlytics

import dev.icerock.moko.crashreporting.core.CrashReportingCore
import dev.icerock.moko.crashreporting.core.ExceptionLogger
import dev.icerock.moko.crashreporting.core.getStackTrace

class CrashlyticsLogger(val nativeLogger: NativeCrashliticsLogger) : ExceptionLogger {

    override fun setUserId(userId: String) {
        nativeLogger.setUserId(userId)
    }

    override fun setCustomValue(value: String, forKey: String) {
        nativeLogger.setCustomValue(value, forKey)
    }

    override fun recordException(throwable: Throwable) {
        val crashReportingCore = CrashReportingCore()
        nativeLogger.recordException(
            name = crashReportingCore.getExceptionName(throwable).orEmpty(),
            message = throwable.message.orEmpty(),
            stackTrace = crashReportingCore.getStackTrace(throwable)
        )
    }

    override fun log(message: String) {
        nativeLogger.log(message)
    }
}

// temporary, in feature replace with full crashlytics integration in this module
interface NativeCrashliticsLogger {
    fun setUserId(userId: String)
    fun setCustomValue(value: String, forKey: String)
    fun recordException(name: String, message: String, stackTrace: List<Long>)
    fun log(message: String)
}
