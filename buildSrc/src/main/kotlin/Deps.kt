/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

object Deps {
    private const val detektVersion = "1.15.0"

    private const val androidAppCompatVersion = "1.1.0"
    private const val napierVersion = "1.4.1"

    private const val googleServicesVersion = "4.3.3"
    private const val firebaseCrashlyticsPluginVersion = "2.2.0"

    private const val firebaseCoreVersion = "17.4.3"
    private const val firebaseCrashlyticsVersion = "17.1.0"

    const val mokoCrashReportingVersion = "0.1.2"


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

        val mobileMultiplatform = GradlePlugin(id = "dev.icerock.mobile.multiplatform")
        val mavenPublish = GradlePlugin(id = "org.gradle.maven-publish")
        val signing = GradlePlugin(id = "signing")

        val detekt = GradlePlugin(id = "io.gitlab.arturbosch.detekt", version = detektVersion)
        val iosFramework = GradlePlugin(id = "dev.icerock.mobile.multiplatform.ios-framework")

        val googleServices = GradlePlugin(
            id = "com.google.gms.google-services",
            module = "com.google.gms:google-services:$googleServicesVersion"
        )
        val firebaseCrashlytics = GradlePlugin(
            id = "com.google.firebase.crashlytics",
            module = "com.google.firebase:firebase-crashlytics-gradle:$firebaseCrashlyticsPluginVersion"
        )

    }

    object Libs {
        object Android {
            const val appCompat = "androidx.appcompat:appcompat:$androidAppCompatVersion"
            const val firebaseCore = "com.google.firebase:firebase-core:$firebaseCoreVersion"
            const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics:$firebaseCrashlyticsVersion"
        }

        object MultiPlatform {

            const val mokoCrashReportingCore =
                "dev.icerock.moko:crash-reporting-core:$mokoCrashReportingVersion"
            const val mokoCrashReportingCrashlytics =
                "dev.icerock.moko:crash-reporting-crashlytics:$mokoCrashReportingVersion"
            const val mokoCrashReportingNapier =
                "dev.icerock.moko:crash-reporting-napier:$mokoCrashReportingVersion"
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
