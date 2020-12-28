package dev.icerock.moko.crashreporting.crashlytics

import cocoapods.MCRCDynamicProxy.FirebaseCrashlyticsReporterProtocol
import cocoapods.MCRCDynamicProxy.FirebaseDynamicProxy
import dev.icerock.moko.crashreporting.core.CrashReportingCore
import dev.icerock.moko.crashreporting.core.setupUnhandledExceptionsHandler
import dev.icerock.moko.crashreporting.core.ExceptionLogger
import dev.icerock.moko.crashreporting.core.getStackTrace
import kotlin.native.concurrent.freeze

actual class CrashlyticsLogger actual constructor() : ExceptionLogger {

    private val reporter: FirebaseCrashlyticsReporterProtocol

    init {
        reporter = FirebaseDynamicProxy.reporter()
            ?: throw IllegalStateException("MokoFirebaseCrashlytics.setup() should be called in swift before creating CrashlyticsLogger")
        freeze()
        setupUnhandledExceptionsHandler(this)
    }

    override fun log(message: String) {
        reporter.logWithMessage(message)
    }

    @ExperimentalUnsignedTypes
    override fun recordException(throwable: Throwable) {
        val name = CrashReportingCore.getExceptionName(throwable)
        val stackTrace = CrashReportingCore.getStackTrace(throwable)

        reporter.recordExceptionWithName(
            name = name,
            reason = throwable.message.orEmpty(),
            stackTrace = stackTrace
        )
    }

    override fun setCustomValue(value: String, forKey: String) {
        reporter.setCustomValueWithValue(
            value = value,
            forKey = forKey
        )
    }

    override fun logFatal(throwable: Throwable) {
        val name = CrashReportingCore.getExceptionName(throwable)
        val stackTrace = CrashReportingCore.getStackTrace(throwable)

        reporter.recordFatalExceptionWithName(
            name = name,
            reason = throwable.message.orEmpty(),
            stackTrace = stackTrace
        )
    }

    override fun setUserId(userId: String) {
        reporter.setUserIdWithUserId(userId)
    }
}
