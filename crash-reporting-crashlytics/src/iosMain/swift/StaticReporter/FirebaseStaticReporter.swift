/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

import FirebaseCrashlytics
import MCRCDynamicProxy

public class MokoFirebaseCrashlytics: FirebaseCrashlyticsReporter {
  public func setUserId(userId: String) {
    Crashlytics.crashlytics().setUserID(userId)
  }
  
  public func setCustomValue(value: String, forKey: String) {
    Crashlytics.crashlytics().setCustomValue(value, forKey: forKey)
  }
  
  public func recordException(name: String, reason: String, stackTrace: [UInt]) {
    let exceptionModel = ExceptionModel(
      name: name,
      reason: reason
    )
    let stackFrames = stackTrace.map {
      StackFrame(address: $0)
    }
    
    exceptionModel.stackTrace = stackFrames
    
    Crashlytics.crashlytics().record(exceptionModel: exceptionModel)
  }
  
  public func recordFatalException(
    name: String,
    reason: String,
    stackTrace: [UInt]
  ) {
    recordException(name: name, reason: reason, stackTrace: stackTrace)
  }
  
  public func log(message: String) {
    Crashlytics.crashlytics().log(message)
  }
  
  public static func setup() {
    FirebaseDynamicProxy.reporter = MokoFirebaseCrashlytics()
  }
}
