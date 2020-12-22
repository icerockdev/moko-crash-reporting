/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

import Foundation

@objc
public class FirebaseDynamicProxy: NSObject {
  @objc
  public static var reporter: FirebaseCrashlyticsReporter? = nil
}

@objc
public protocol FirebaseCrashlyticsReporter {
  func setUserId(userId: String)
  func setCustomValue(value: String, forKey: String)
  func recordException(name: String, reason: String, stackTrace: [UInt])
  func log(message: String)
}
