/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.crashreporting.core

interface ExceptionLogger {
    fun setUserId(userId: String)
    fun setCustomValue(value: String, forKey: String)
    fun recordException(throwable: Throwable)
    fun log(message: String)
    fun logFatal(throwable: Throwable)
}
