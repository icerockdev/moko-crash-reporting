/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

buildscript {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        jcenter()
    }

    dependencies {
        classpath("com.google.gms:google-services:4.3.8")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.2.0")

        classpath(":crash-reporting-build-logic")
    }
}

allprojects {
    plugins.withId("org.gradle.maven-publish") {
        group = "dev.icerock.moko"
        version = libs.versions.mokoCrashReportingVersion.get()
    }
}

tasks.register("clean", Delete::class).configure {
    group = "build"
    delete(rootProject.buildDir)
}
