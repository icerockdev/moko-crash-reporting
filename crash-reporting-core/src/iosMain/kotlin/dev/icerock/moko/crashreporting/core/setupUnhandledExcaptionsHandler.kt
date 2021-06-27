/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.crashreporting.core

import kotlin.native.concurrent.freeze

fun setupUnhandledExceptionsHandler(logger: ExceptionLogger) {
    val hook: ReportUnhandledExceptionHook = { exc: Throwable ->
        logger.logFatal(throwable = exc)
    }
    setUnhandledExceptionHook(hook.freeze())
}
