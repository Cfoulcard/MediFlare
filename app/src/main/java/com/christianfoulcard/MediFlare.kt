package com.christianfoulcard

import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import com.christianfoulcard.mediflare.utils.LogUtils.TAG

/**
 * This is a custom Application class that extends the Android Application class.
 * It is used to initialize and manage the global application context for the entire app.
 */
class MediFlare: Application() {

    override fun onCreate() {
        super.onCreate()
        globalAppContext = applicationContext
    }

    fun getAppVersion(context: Context): String {
        try {
            val pInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            return pInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            Log.d(TAG, "Could not find name")
        }
        return ""
    }

    companion object {

        /** This allows access to the application context from anywhere in the app. */
        lateinit var globalAppContext: Context

        fun getAppContext(): Context {
            return globalAppContext
        }
    }
}