package dev.icerock.moko.crashreporting.crashlytics

import cocoapods.FirebaseCrashlytics.FIRCrashlytics
import cocoapods.FirebaseCrashlytics.FIRExceptionModel
import cocoapods.FirebaseCrashlytics.FIRStackFrame
import dev.icerock.moko.crashreporting.core.CrashReportingCore
import dev.icerock.moko.crashreporting.core.ExceptionLogger
import dev.icerock.moko.crashreporting.core.getStackTrace

actual class CrashlyticsLogger actual constructor() : ExceptionLogger {
    actual override fun log(message: String) {
        FIRCrashlytics.crashlytics().log(message)
    }

    @ExperimentalUnsignedTypes
    actual override fun recordException(throwable: Throwable) {
        val crashReportingCore = CrashReportingCore()
        val name = crashReportingCore.getExceptionName(throwable).orEmpty()
        val stackTrace = crashReportingCore.getStackTrace(throwable)
        val exceptionModel = FIRExceptionModel.exceptionModelWithName(
            name = name,
            reason = throwable.message.orEmpty()
        )
        val stackFrames = stackTrace.map {
            FIRStackFrame.stackFrameWithAddress(address = it.toULong())
        }

        exceptionModel.stackTrace = stackFrames

        FIRCrashlytics.crashlytics().recordExceptionModel(exceptionModel)
    }

    actual override fun setCustomValue(value: String, forKey: String) {
        FIRCrashlytics.crashlytics().setCustomValue(value = value, forKey = forKey)
    }

    actual override fun setUserId(userId: String) {
        FIRCrashlytics.crashlytics().setUserID(userId)
    }
}
