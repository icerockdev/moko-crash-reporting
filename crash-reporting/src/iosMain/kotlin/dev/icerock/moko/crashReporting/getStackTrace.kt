package dev.icerock.moko.crashReporting

actual fun CrashlyticsCore.getStackTrace(throwable: Throwable): List<Long> {
    return throwable.getStackTraceAddresses()
}
