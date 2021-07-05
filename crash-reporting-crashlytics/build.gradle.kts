/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("multiplatform-library-convention")
    id("dev.icerock.mobile.multiplatform.android-manifest")
    id("publication-convention")
    id("dev.icerock.mobile.multiplatform.cocoapods")
}

dependencies {
    commonMainApi(projects.crashReportingCore)

    androidMainImplementation(libs.appCompat)
    androidMainImplementation(libs.firebaseCore)
    androidMainImplementation(libs.firebaseCrashlytics)
}

cocoaPods {
    podsProject = file("../sample/ios-app/Pods/Pods.xcodeproj")

    pod("MCRCDynamicProxy")
}