package com.example.androidstudioguide

import android.app.Application
import android.content.Context

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        val myContext: Context = this
    }
}