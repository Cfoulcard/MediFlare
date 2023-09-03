package com.christianfoulcard.mediflare.utils

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.core.view.WindowCompat
import com.christianfoulcard.mediflare.R

class SystemUi {

    fun whiteStatusAndNavBars(activity: Activity) {
        activity.window.statusBarColor = activity.resources.getColor(R.color.white)
        activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        WindowCompat.setDecorFitsSystemWindows(activity.window, false)
        activity.window.navigationBarColor = activity.resources.getColor(R.color.white)
    }

    fun hideSystemUIFull(activity: Activity) {
        activity.window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    fun hideSystemUI(activity: Activity) {

        // Hides action bar
        activity.actionBar?.hide()

        // Hide the status bars
        WindowCompat.setDecorFitsSystemWindows(activity.window, false)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        } else {
            activity.window.insetsController?.apply {
                hide(WindowInsets.Type.statusBars())
                systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
    }



}