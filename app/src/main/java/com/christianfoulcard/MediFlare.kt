package com.christianfoulcard

import android.app.Application
import android.content.Context

class MediFlare: Application() {

    override fun onCreate() {
        super.onCreate()
        globalAppContext = applicationContext
    }

    companion object {
        lateinit var globalAppContext: Context
            private set
    }
}