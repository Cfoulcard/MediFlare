package com.christianfoulcard.mediflare.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.christianfoulcard.mediflare.R
import com.christianfoulcard.mediflare.composables.BottomNavTabs.EvenlySpacedBottomNavigationBar
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
        Surface(modifier = Modifier.fillMaxSize(), color = colorResource(id = R.color.white)) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter,
            ) {
                EvenlySpacedBottomNavigationBar()
            }
        }
    }
}

    @Preview(showBackground = true)
    @Composable
    fun PreviewHomeScreen() {
        DisplayHomeScreen()
    }
