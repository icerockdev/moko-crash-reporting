/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.crashreporting.core

import kotlin.native.concurrent.AtomicReference
import kotlin.native.concurrent.freeze
import kotlinx.cinterop.staticCFunction
import platform.Foundation.NSThread
import platform.darwin.*
import kotlin.native.concurrent.DetachedObjectGraph
import kotlin.native.concurrent.TransferMode
import kotlin.native.concurrent.attach

fun CrashReportingCore.setupUnhandledExceptionsHandler(logger: ExceptionLogger) {
    val atomicReference = AtomicReference(logger).freeze()
    val hook: ReportUnhandledExceptionHook = { exc: Throwable ->
        val freezeExc = exc.freeze()
        dispatch_async_f(
            dispatch_get_main_queue(),
            DetachedObjectGraph(TransferMode.UNSAFE) {
                Pair(
                    atomicReference,
                    freezeExc
                )
            }.asCPointer(),
            staticCFunction { pointer ->
                val pair =
                    DetachedObjectGraph<Pair<AtomicReference<ExceptionLogger>, Throwable>>(pointer).attach()
                pair.first.value.logFatal(throwable = pair.second)
            }
        )
    }
    setUnhandledExceptionHook(hook.freeze())
}