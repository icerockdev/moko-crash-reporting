/*
  * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
  */

subprojects {
    configurations.all {
        resolutionStrategy.dependencySubstitution {
            substitute(module(Deps.Libs.MultiPlatform.mokoCrashReportingCore))
                .with(project(":crash-reporting-core"))
            substitute(module(Deps.Libs.MultiPlatform.mokoCrashReportingCrashlytics))
                .with(project(":crash-reporting-crashlytics"))
            substitute(module(Deps.Libs.MultiPlatform.mokoCrashReportingNapier))
                .with(project(":crash-reporting-napier"))
        }
    }
}