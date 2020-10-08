package dev.icerock.moko.crashreporting.core

actual val <T : Any> T.noReflectionSimpleName: String?
    get() = this::class.simpleName
