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
    commonMainImplementation(Deps.Libs.MultiPlatform.serialization)
    commonMainImplementation(Deps.Libs.MultiPlatform.napier.common)
    commonMainApi(Deps.Libs.MultiPlatform.mokoCrashReporting)
}

framework {
    export(project(":crash-reporting"))
}
