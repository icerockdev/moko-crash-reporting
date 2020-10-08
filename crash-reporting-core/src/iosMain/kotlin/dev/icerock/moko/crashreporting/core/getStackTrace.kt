package dev.icerock.moko.crashreporting.core

actual fun CrashReportingCore.getStackTrace(throwable: Throwable): List<Long> {
    return throwable.getStackTraceAddresses()
}
