![moko-crash-reporting](https://user-images.githubusercontent.com/701307/98647965-37858400-2368-11eb-98e8-6e62d75fa6af.png)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0) [![Download](https://img.shields.io/maven-central/v/dev.icerock.moko/crash-reporting) ](https://repo1.maven.org/maven2/dev/icerock/moko/crash-reporting) ![kotlin-version](https://img.shields.io/badge/kotlin-1.4.31-orange)

# Mobile Kotlin crash report

This is a Kotlin MultiPlatform library that provides reporting fatal and non-fatal exceptions from common code.

## Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Versions](#versions)
- [Installation](#installation)
- [Usage](#usage)
- [Samples](#samples)
- [Set Up Locally](#set-up-locally)
- [Contributing](#contributing)
- [License](#license)

## Features
- **CrashlyticsLogger** implementation of **ExceptionLogger**, for logging messages and non-fatals to FirebaseCrashlytics.
- **CrashReportingAntilog** can be used for **Napier** logger to log messages and errors by **ExceptionLogger**

## Requirements
- Gradle version 6.0+
- Android API 16+
- iOS version 9.0+

## Versions
### Bintray
- kotlin 1.4.10
  - 0.1.0
- kotlin 1.4.21
  - 0.1.1
### mavenCentral
- kotlin 1.4.31
  - 0.1.2

## Installation
root build.gradle  
```groovy
allprojects {
    repositories {
        mavenCentral()
        maven { url = uri("https://dl.bintray.com/aakira/maven") } // for CrashReportingAntilog
    }
}
```
project build.gradle
```groovy
dependencies {
    commonMainImplementation("dev.icerock.moko:crash-reporting-crashlytics:0.1.2") // for CrashlyticsLogger
    commonMainImplementation("dev.icerock.moko:crash-reporting-napier:0.1.2") // for CrashReportingAntilog
    commonMainImplementation("com.github.aakira:napier:1.4.1") // for CrashReportingAntilog
}
```
For CrashlyticsLogger need to add FirebaseCrashlytics cocoapod
With [mobile-multiplatform-gradle-plugin](https://github.com/icerockdev/mobile-multiplatform-gradle-plugin) cocoapods configuration simplest:
`build.gradle.kts`:
```kotlin
cocoaPods {
    podsProject = file("ios-app/Pods/Pods.xcodeproj")

    pod("MCRCDynamicProxy", onlyLink = true)
}
```
project Podfile
```ruby
pod 'MCRCDynamicProxy', :git => 'https://github.com/icerockdev/moko-crash-reporting.git', :tag => 'release/0.1.2'
pod 'MCRCStaticReporter', :git => 'https://github.com/icerockdev/moko-crash-reporting.git', :tag => 'release/0.1.2'
```

On iOS side add to `AppDelegate`:
```swift
import FirebaseCore
import MCRCStaticReporter

...

func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]? = nil) -> Bool {
    FirebaseApp.configure()
    MokoFirebaseCrashlytics.setup()
    ...
}
```

## Usage

### CrashlyticsLogger
If you haven't already, add Firebase to your project, you can see how to do it [here](https://firebase.google.com/docs/crashlytics/get-started)

```kotlin
val logger = CrashlyticsLogger()

// setting user id in crashlytics 
logger.setUserId("User_1")

// setting custom key-value in crashlytics 
logger.setCustomValue("customValue", "customKey")

// log message in crashlytics
logger.log("Hello World")

// send non-fatal exception to crashlytics
try {
    "test".toInt()
} catch (e: NumberFormatException) {
    logger.recordException(e)
}
```

### CrashReportingAntilog
```kotlin
val logger = CrashlyticsLogger() // CrashlyticsLogger for example, you can use any ExceptionLogger implementation

// initialize napier
Napier.base(antilog = CrashReportingAntilog(exceptionLogger = logger))

// All messages will be logged by exceptionLogger
Napier.d(message = "Hello World")
Napier.i(message = "This is random message", tag = "FYI")
Napier.w(message = "Something goes wrong", tag = "Alarm")
Napier.v(message = "just verbose", tag = "VERBOSE")

// throwable will be recorded by exceptionLogger
try {
    "test".toInt()
} catch (e: NumberFormatException) {
    Napier.e(message = "test is not a number", tag = "Non fatal", throwable = e)
}
```

## Samples
Please see more examples in the [sample directory](sample).

## Set Up Locally 
- The [crash-reporting-core](crash-reporting-core) contains basic classes and interfaces needed for crash reporting;
- The [crash-reporting-crashlytics](crash-reporting-crashlytics) contains integraion with firebase crashlytics;
- The [crash-reporting-napier](crash-reporting-napier) contains integration with [napier](https://github.com/AAkira/Napier) logger;
- The [sample directory](sample) contains sample apps for Android and iOS; plus the mpp-library connected to the apps.


## Contributing
All development (both new features and bug fixes) is performed in the `develop` branch. This way `master` always contains the sources of the most recently released version. Please send PRs with bug fixes to the `develop` branch. Documentation fixes in the markdown files are an exception to this rule. They are updated directly in `master`.

The `develop` branch is pushed to `master` on release.

For more details on contributing please see the [contributing guide](CONTRIBUTING.md).

## License
        
    Copyright 2020 IceRock MAG Inc.
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
