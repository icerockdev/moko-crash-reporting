/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

object Deps {

    private const val kotlinVersion = "1.4.0"
    private const val detektVersion = "1.7.4"

    private const val androidAppCompatVersion = "1.1.0"
    private const val kotlinxSerializationVersion = "1.0.0-RC"
    private const val napierVersion = "1.4.1"

    const val mokoCrashReportingVersion = "0.1.0"


    object Android {
        const val compileSdk = 28
        const val targetSdk = 28
        const val minSdk = 16
    }

    object Plugins {
        val androidApplication = GradlePlugin(id = "com.android.application")
        val androidLibrary = GradlePlugin(id = "com.android.library")

        val kotlinMultiplatform = GradlePlugin(id = "org.jetbrains.kotlin.multiplatform")
        val kotlinAndroid = GradlePlugin(id = "kotlin-android")
        val kotlinAndroidExtensions = GradlePlugin(id = "kotlin-android-extensions")

        val mobileMultiplatform = GradlePlugin(id = "dev.icerock.mobile.multiplatform")
        val mavenPublish = GradlePlugin(id = "org.gradle.maven-publish")

        val detekt = GradlePlugin(id = "io.gitlab.arturbosch.detekt", version = detektVersion)
        val iosFramework = GradlePlugin(id = "dev.icerock.mobile.multiplatform.ios-framework")
    }

    object Libs {
        object Android {
            const val appCompat = "androidx.appcompat:appcompat:$androidAppCompatVersion"
        }

        object MultiPlatform {

            const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:$kotlinxSerializationVersion"
            const val mokoCrashReporting = "dev.icerock.moko:crash-reporting:$mokoCrashReportingVersion"
            val napier = MultiPlatformLibrary(
                common = "com.github.aakira:napier:$napierVersion",
                iosX64 = "com.github.aakira:napier-iosx64:$napierVersion",
                iosArm64 = "com.github.aakira:napier-iosarm64:$napierVersion"
            )

        }

        object Jvm {
            const val detektFormatting =
                "io.gitlab.arturbosch.detekt:detekt-formatting:$detektVersion"
        }
    }
}
