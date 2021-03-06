/*
* Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
*/

import FirebaseCore
import MultiPlatformLibrary
import MCRCStaticReporter
import UIKit

@UIApplicationMain
class AppDelegate: NSObject, UIApplicationDelegate {
    
    var window: UIWindow?
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]? = nil) -> Bool {
        FirebaseApp.configure()
        MokoFirebaseCrashlytics.setup()
        return true
    }
}
