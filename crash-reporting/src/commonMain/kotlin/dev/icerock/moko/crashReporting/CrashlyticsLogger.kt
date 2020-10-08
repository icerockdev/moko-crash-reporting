package dev.icerock.moko.crashReporting

interface CrashlyticsLogger {
    fun setUserId(userId: String)
    fun setCustomValue(value: String, forKey: String)
    fun recordException(name: String, message: String, stackTrace: List<Long>)
    fun log(message: String)
}
