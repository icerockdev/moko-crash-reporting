package dev.icerock.moko.crashReporting

import com.github.aakira.napier.Napier

class CrashlyticsCore(private val logger: CrashlyticsLogger) {
    // set user id for crashlytics report
    fun setUserId(userId: String) {
        logger.setUserId(userId)
    }

    // set custom key for crashlytics report
    fun setCustomValue(value: String, forKey: String) {
        logger.setCustomValue(value, forKey)
    }

    // record custom non fatal exception to crashlytics
    fun recordException(throwable: Throwable) {
        val exceptionName = throwable.noReflectionSimpleName.orEmpty()
        val message = throwable.message.orEmpty()
        val stackTrace = getStackTrace(throwable).orEmpty()

        logger.recordException(name = exceptionName, message = message, stackTrace = stackTrace)
    }

    // add custom log string for crashlytics report
    fun log(logLevel: Napier.Level, tag: String?, message: String?) {
        var logText = "${logLevel.name}:"

        tag?.let { logText = logText.plus(" $tag - ") }
        message?.let { logText = logText.plus(message) }

        logger.log(logText)
    }
}

expect fun CrashlyticsCore.getStackTrace(throwable: Throwable): List<Long>
