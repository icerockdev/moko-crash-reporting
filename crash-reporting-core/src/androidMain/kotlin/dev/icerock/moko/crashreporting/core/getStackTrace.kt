/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.crashreporting.core

actual fun CrashReportingCore.getStackTrace(throwable: Throwable): List<Long> {
    // Android don't need stack trace
    return listOf()
}
