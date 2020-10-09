/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.crashreporting.crashlytics

import dev.icerock.moko.crashreporting.core.ExceptionLogger

expect class CrashlyticsLogger() : ExceptionLogger {
    override fun log(message: String)
    override fun recordException(throwable: Throwable)
    override fun setCustomValue(value: String, forKey: String)
    override fun setUserId(userId: String)
}
