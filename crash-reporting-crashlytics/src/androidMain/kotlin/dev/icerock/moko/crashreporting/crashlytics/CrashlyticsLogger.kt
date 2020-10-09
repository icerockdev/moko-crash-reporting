/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.crashreporting.crashlytics

import dev.icerock.moko.crashreporting.core.ExceptionLogger

actual class CrashlyticsLogger actual constructor() : ExceptionLogger {
    actual override fun log(message: String) {
        TODO("Not yet implemented")
    }

    actual override fun recordException(throwable: Throwable) {
        TODO("Not yet implemented")
    }

    actual override fun setCustomValue(value: String, forKey: String) {
        TODO("Not yet implemented")
    }

    actual override fun setUserId(userId: String) {
        TODO("Not yet implemented")
    }
}
