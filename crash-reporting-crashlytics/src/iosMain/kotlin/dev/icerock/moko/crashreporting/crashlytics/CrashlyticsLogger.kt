package dev.icerock.moko.crashreporting.crashlytics

import cocoapods.MCRCDynamicProxy.FirebaseCrashlyticsReporterProtocol
import cocoapods.MCRCDynamicProxy.FirebaseDynamicProxy
import dev.icerock.moko.crashreporting.core.CrashReportingCore
import dev.icerock.moko.crashreporting.core.ExceptionLogger
import dev.icerock.moko.crashreporting.core.getStackTrace

actual class CrashlyticsLogger actual constructor() : ExceptionLogger {
    private val reporter: FirebaseCrashlyticsReporterProtocol = FirebaseDynamicProxy.reporter()
        ?: throw IllegalStateException(
            "MokoFirebaseCrashlytics.setup() should be called in swift before creating CrashlyticsLogger"
        )

    override fun log(message: String) {
        reporter.logWithMessage(message)
    }

    override fun recordException(throwable: Throwable) {
        val name: String = CrashReportingCore.getExceptionName(throwable)
        val stackTrace: List<Long> = CrashReportingCore.getStackTrace(throwable)

        reporter.recordExceptionWithName(
            name = name,
            reason = throwable.message.orEmpty(),
            stackTrace =
        )
    }

    override fun setCustomValue(value: String, forKey: String) {
        reporter.setCustomValueWithValue(
            value = value,
            forKey = forKey
        )
    }

    override fun setUserId(userId: String) {
        reporter.setUserIdWithUserId(userId)
    }
}
