/*
* Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
*/

import UIKit
import MultiPlatformLibrary

class TestViewController: UIViewController {
    
    let testing = Testing(crashlyticsLogger: IosCrashlyticsLogger())
    
    override func viewDidLoad() {
        super.viewDidLoad()

    }
    
    @IBAction
    func onSetUserId() {
        testing.setUserId()
    }
    
    @IBAction
    func onSetCustomValue() {
        testing.setCustomValue()
    }
    
    @IBAction
    func onSendRandomLog() {
        testing.logRandomTestMessage()
    }
    
    @IBAction
    func onSendException() {
        testing.logException()
    }
}
