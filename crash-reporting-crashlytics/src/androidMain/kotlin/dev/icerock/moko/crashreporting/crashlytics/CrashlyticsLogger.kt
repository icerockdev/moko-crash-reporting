/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.crashreporting.crashlytics

import com.google.firebase.crashlytics.FirebaseCrashlytics
import dev.icerock.moko.crashreporting.core.ExceptionLogger

@Suppress("EmptyDefaultConstructor")
actual class CrashlyticsLogger actual constructor() : ExceptionLogger {
    override fun log(message: String) {
        FirebaseCrashlytics.getInstance().log(message)
    }

    override fun recordException(throwable: Throwable) {
        FirebaseCrashlytics.getInstance().recordException(throwable)
    }

    override fun setCustomValue(value: String, forKey: String) {
        FirebaseCrashlytics.getInstance().setCustomKey(value, forKey)
    }

    override fun setUserId(userId: String) {
        FirebaseCrashlytics.getInstance().setUserId(userId)
    }
}
