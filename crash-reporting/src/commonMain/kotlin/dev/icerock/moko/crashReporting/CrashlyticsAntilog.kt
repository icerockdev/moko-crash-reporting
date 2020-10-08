package dev.icerock.moko.crashReporting

import com.github.aakira.napier.Antilog
import com.github.aakira.napier.Napier

class CrashlyticsAntilog(private val core: CrashlyticsCore) : Antilog() {
    override fun performLog(
        priority: Napier.Level,
        tag: String?,
        throwable: Throwable?,
        message: String?
    ) {
        core.log(logLevel = priority, tag = tag, message = message)
        throwable?.let { core.recordException(throwable) }
    }
}
