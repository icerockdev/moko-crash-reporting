/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("dev.icerock.moko.gradle.android.application")
    id("dev.icerock.moko.gradle.detekt")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    buildFeatures.dataBinding = true

    defaultConfig {
        // multidex required because google services here :(
        minSdk = 21

        applicationId = "dev.icerock.moko.samples.crashreporting"

        versionCode = 1
        versionName = "0.1.0"
    }
}

dependencies {
    implementation(libs.googleServices)
    implementation(libs.appCompat)
    implementation(libs.firebaseAnalytics)
    implementation(libs.firebaseCrashlytics)
    implementation(projects.sample.mppLibrary)
}

