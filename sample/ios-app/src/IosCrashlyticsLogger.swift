//
//  IosCrashlyticsLogger.swift
//  TestProj
//
//  Created by Andrey Dorofeev on 08.10.2020.
//  Copyright © 2020 IceRock Development. All rights reserved.
//

import FirebaseCrashlytics
import MultiPlatformLibrary

class IosCrashlyticsLogger: NativeCrashliticsLogger {
    func log(message: String) {
        Crashlytics.crashlytics().log(message)
    }
    
    func recordException(name: String, message: String, stackTrace: [KotlinLong]) {
        let ex = ExceptionModel.init(name: name, reason: message)
        let stackFrames = stackTrace.map { (address) -> StackFrame in
            StackFrame(address: UInt(truncating: address))
        }
        ex.stackTrace = stackFrames
        
        Crashlytics.crashlytics().record(exceptionModel:ex)
    }
    
    func setCustomValue(value: String, forKey: String) {
        Crashlytics.crashlytics().setCustomValue(value, forKey: forKey)
    }
    
    func setUserId(userId: String) {
        Crashlytics.crashlytics().setUserID(userId)
    }
}
