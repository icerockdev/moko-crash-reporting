package dev.icerock.moko.crashReporting

actual val <T : Any> T.noReflectionSimpleName: String?
    get() = this::class.java.simpleName
