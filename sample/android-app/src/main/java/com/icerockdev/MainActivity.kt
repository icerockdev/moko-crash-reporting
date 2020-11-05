/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package com.icerockdev

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.icerockdev.library.Testing

class MainActivity : AppCompatActivity() {

    lateinit var testing: Testing

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        testing = Testing()

        findViewById<Button>(R.id.setUserId).setOnClickListener { testing.setUserId() }
        findViewById<Button>(R.id.setCustomValue).setOnClickListener { testing.setCustomValue() }
        findViewById<Button>(R.id.logMessage).setOnClickListener { testing.logRandomTestMessage() }
        findViewById<Button>(R.id.send_non_fatal).setOnClickListener { testing.logException() }
    }
}
