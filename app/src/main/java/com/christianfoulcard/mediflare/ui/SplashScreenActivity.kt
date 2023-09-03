package com.christianfoulcard.mediflare.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.christianfoulcard.mediflare.R
import com.christianfoulcard.mediflare.composables.Images.AnimatedLogoAlphaImageFullScreen
import com.christianfoulcard.mediflare.composables.Images.MediFlareLogoFullScreen
import com.christianfoulcard.mediflare.ui.theme.MediFlareTheme
import com.christianfoulcard.mediflare.utils.Constants.SPLASH_TIME_OUT
import com.christianfoulcard.mediflare.utils.SystemUi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemUi().hideSystemUIFull(this)

        setContent {
            MediFlareTheme {
                Column {
                    AnimatedLogoAlphaImageFullScreen()
                }
            }
        }

        navigateToLoginScreen()
    }

    private fun navigateToLoginScreen() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(SPLASH_TIME_OUT)
            startActivity(Intent(this@SplashScreenActivity, LoginScreenActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        MediFlareTheme {
            MediFlareLogoFullScreen()
        }
    }

}