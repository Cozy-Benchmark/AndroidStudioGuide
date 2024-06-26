package com.example.androidstudioguide

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class TestReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, intent: Intent?) {
        if (intent?.action == "Test_Action") {
            println("Received test intent.")
        }
    }
}