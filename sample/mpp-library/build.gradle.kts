/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    plugin(Deps.Plugins.androidLibrary)
    plugin(Deps.Plugins.kotlinMultiplatform)
    plugin(Deps.Plugins.mobileMultiplatform)
    plugin(Deps.Plugins.iosFramework)
}

dependencies {
    commonMainImplementation(Deps.Libs.MultiPlatform.napier.common)
    commonMainApi(Deps.Libs.MultiPlatform.mokoCrashReportingCore)
    commonMainApi(Deps.Libs.MultiPlatform.mokoCrashReportingCrashlytics)
    commonMainApi(Deps.Libs.MultiPlatform.mokoCrashReportingNapier)
}

framework {
    export(project(":crash-reporting-core"))
    export(project(":crash-reporting-crashlytics"))
    export(project(":crash-reporting-napier"))
}

cocoaPods {
    podsProject = file("../ios-app/Pods/Pods.xcodeproj")

    pod("GoogleUtilities", onlyLink = false)
    pod("FirebaseCrashlytics", onlyLink = true)
}