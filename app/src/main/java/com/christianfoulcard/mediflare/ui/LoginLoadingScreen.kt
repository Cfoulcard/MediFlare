package com.christianfoulcard.mediflare.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.christianfoulcard.mediflare.R
import com.christianfoulcard.mediflare.composables.BottomNavTabs
import com.christianfoulcard.mediflare.composables.Images.AnimatedLogoAlphaImageFullScreenLoading
import com.christianfoulcard.mediflare.ui.theme.MediFlareTheme
import com.christianfoulcard.mediflare.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginLoadingScreen : ComponentBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayLoginLoadingScreen()
            navigateToHomeScreen()
        }

    }

    private fun navigateToHomeScreen() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(Constants.LOAD_SCREEN_TIME_OUT)
            startActivity(Intent(this@LoginLoadingScreen, HomeScreenActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
        }
    }
}

@Composable
fun DisplayLoginLoadingScreen() {
    MediFlareTheme {
        AnimatedLogoAlphaImageFullScreenLoading()
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewLoginLoadScreen() {
    DisplayLoginLoadingScreen()
}