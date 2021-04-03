/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    plugin(Deps.Plugins.androidLibrary)
    plugin(Deps.Plugins.kotlinMultiplatform)
    plugin(Deps.Plugins.mobileMultiplatform)
    plugin(Deps.Plugins.mavenPublish)
}

dependencies {
    commonMainApi(project(":crash-reporting-core"))

    androidMainImplementation(Deps.Libs.Android.appCompat)

    androidMainImplementation(Deps.Libs.Android.firebaseCore)
    androidMainImplementation(Deps.Libs.Android.firebaseCrashlytics)
}

cocoaPods {
    podsProject = file("../sample/ios-app/Pods/Pods.xcodeproj")

    pod("MCRCDynamicProxy")
}