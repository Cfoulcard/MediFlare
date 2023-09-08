package com.christianfoulcard.mediflare.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.christianfoulcard.mediflare.composables.BottomNavTabs.MainScreenWithBottomNav
import com.christianfoulcard.mediflare.ui.theme.MediFlareTheme

class HomeScreenActivity : ComponentBaseActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                DisplayHomeScreen()
            }
        }

    }

@Composable
fun DisplayHomeScreen() {
    MediFlareTheme {
        MainScreenWithBottomNav()
    }
}

    @Preview(showBackground = true)
    @Composable
    fun PreviewHomeScreen() {
        DisplayHomeScreen()
    }
