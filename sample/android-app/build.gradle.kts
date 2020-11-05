/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    plugin(Deps.Plugins.androidApplication)
    plugin(Deps.Plugins.kotlinAndroid)
    plugin(Deps.Plugins.googleServices)
    plugin(Deps.Plugins.firebaseCrashlytics)
}

android {
    compileSdkVersion(Deps.Android.compileSdk)

    dexOptions {
        javaMaxHeapSize = "2g"
    }

    defaultConfig {
        minSdkVersion(Deps.Android.minSdk)
        targetSdkVersion(Deps.Android.targetSdk)

        applicationId = "dev.icerock.moko.samples.crashreporting.debug"

        versionCode = 1
        versionName = "0.1.0"

        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isDebuggable = true
        }
    }

    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }
}

dependencies {

    implementation(Deps.Libs.Android.appCompat)
    implementation(Deps.Libs.Android.firebaseCore)
    implementation(Deps.Libs.Android.firebaseCrashlytics)

    implementation(project("${parent!!.path}:mpp-library"))
}

