/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("com.android.library")
    id("android-base-convention")
    id("detekt-convention")
    id("org.jetbrains.kotlin.multiplatform")
    id("dev.icerock.mobile.multiplatform.android-manifest")
    id("dev.icerock.mobile.multiplatform.ios-framework")
    id("dev.icerock.mobile.multiplatform.cocoapods")
}

kotlin {
    android()
    ios()
}

dependencies {
    commonMainImplementation(libs.napier)
    commonMainApi(projects.crashReportingCore)
    commonMainApi(projects.crashReportingCrashlytics)
    commonMainApi(projects.crashReportingNapier)
}

framework {
    export(projects.crashReportingCore)
    export(projects.crashReportingCrashlytics)
    export(projects.crashReportingNapier)
}

cocoaPods {
    podsProject = file("../ios-app/Pods/Pods.xcodeproj")

    pod("MCRCDynamicProxy", onlyLink = true)
}