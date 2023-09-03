package com.christianfoulcard.mediflare.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.christianfoulcard.mediflare.composables.Buttons.LoginButton
import com.christianfoulcard.mediflare.composables.Images.MediFlareLogo
import com.christianfoulcard.mediflare.composables.TextFields.PasswordTextField
import com.christianfoulcard.mediflare.composables.TextFields.UsernameAndEmailTextField
import com.christianfoulcard.mediflare.ui.theme.MediFlareTheme

class LoginScreenActivity : ComponentBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayLayout()
        }
    }
}

@Composable
fun DisplayLayout() {
    MediFlareTheme {
        val screenHeight = LocalConfiguration.current.screenHeightDp.dp
        val offsetHeight = screenHeight * 0.33f

        Surface(modifier = Modifier.fillMaxSize()) {
            Box(
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Spacer(modifier = Modifier.height(offsetHeight * 1F))
                    MediFlareLogo()
                    Spacer(Modifier.size(128.dp))
                    UsernameAndEmailTextField(modifier = Modifier)
                    Spacer(Modifier.size(30.dp))
                    PasswordTextField()
                    Spacer(Modifier.size(30.dp))
                    LoginButton()
                }
            }
            Box(contentAlignment = Alignment.BottomCenter) {
                Text(
                    "Version 1.0.0",
                    modifier = Modifier.padding(32.dp)
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    DisplayLayout()
}