package com.christianfoulcard.mediflare.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.christianfoulcard.mediflare.utils.SystemUi

abstract class ComponentBaseActivity: ComponentActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
           // SystemUi().hideSystemUIFull(this)
            SystemUi().whiteStatusAndNavBars(this)
        }

        override fun onStart() {
            super.onStart()
        }

        override fun onResume() {
            super.onResume()
        }

        override fun onPause() {
            super.onPause()
        }

        override fun onStop() {
            super.onStop()
        }

        override fun onDestroy() {
            super.onDestroy()
        }

    }
