package dev.icerock.moko.crashreporting.core

actual fun CrashReportingCore.getStackTrace(throwable: Throwable): List<Long> {
    // Android don't need stack trace
    return listOf()
}
