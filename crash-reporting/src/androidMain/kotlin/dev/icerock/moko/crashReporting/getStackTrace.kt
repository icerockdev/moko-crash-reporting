package dev.icerock.moko.crashReporting

actual fun CrashlyticsCore.getStackTrace(throwable: Throwable): List<Long> {
    // Android don't need stack trace
    return listOf()
}
