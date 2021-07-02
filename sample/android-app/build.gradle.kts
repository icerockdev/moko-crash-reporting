/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("android-app-convention")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
}

android {
    buildFeatures.dataBinding = true

    defaultConfig {
        applicationId = "dev.icerock.moko.samples.crashreporting.debug"

        versionCode = 1
        versionName = "0.1.0"
    }
}

dependencies {
    implementation(libs.googleServises)
    implementation(libs.appCompat)
    implementation(libs.firebaseCore)
    implementation(libs.firebaseCrashlytics)
    implementation(projects.sample.mppLibrary)
}

