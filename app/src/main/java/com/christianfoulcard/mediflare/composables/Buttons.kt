package com.christianfoulcard.mediflare.composables

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.christianfoulcard.MediFlare
import com.christianfoulcard.mediflare.R
import com.christianfoulcard.mediflare.composables.Buttons.ManagementCardButtons
import com.christianfoulcard.mediflare.ui.HomeScreenActivity
import com.christianfoulcard.mediflare.ui.LoginLoadingScreen
import com.christianfoulcard.mediflare.ui.LoginScreenActivity

object Buttons {

    /**
     * This is a pseudo login button to demonstrate what could happen in an
     * actual real scenario. Simply put the user would transition to a loading screen
     * (in which data would load for the user in the background) and then the
     * home screen would load afterwards
     */
    @Composable
    fun LoginButton(context: Context, activity: Activity) {
        Button(
            onClick = {
                activity.startActivity(Intent(context, LoginLoadingScreen::class.java))
                activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                activity.finish()
            },
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button_blue)),
            modifier = Modifier
                .fillMaxWidth(0.75F)
                .height(60.dp))
        {
            Text(text = stringResource(R.string.login), style = MaterialTheme.typography.headlineSmall)
        }
    }

    @Composable
    fun ContactButton(string: String) {
        Button(
            onClick = {
                      Toast.makeText(MediFlare.getAppContext(), "$string's phone has received a ping from you", LENGTH_SHORT).show()
            },
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button_blue)),
            modifier = Modifier
                .fillMaxWidth(0.90F)
                .height(50.dp)
                )
        {
            Text(text = "Contact $string", style = MaterialTheme.typography.titleSmall)
        }
    }

    @Composable
    fun ManagementCardButtons(title1: String, title2: String, onClickString: String) {

        val gradient = Brush.horizontalGradient(
            colors = listOf(
                colorResource(id = R.color.gradient_dark_blue),  // Start color
                colorResource(id = R.color.gradient_light_blue)   // End color
            )
        )

        val gradientRed = Brush.verticalGradient(
            colors = listOf(
                colorResource(id = R.color.gradient_light_red),  // Start color
                colorResource(id = R.color.gradient_dark_red)   // End color
            )
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clickable(onClick = { Toast.makeText(MediFlare.getAppContext(), onClickString, LENGTH_SHORT).show() })
        ) {
            Box(
                modifier = Modifier
                    .background(brush = when (title2) {
                        "Alerts" -> { gradientRed }
                        else -> { gradient }
                    })
                    .fillMaxWidth()
                    .padding(12.dp)
                    .height(75.dp),
                contentAlignment = Alignment.Center
            ) {

                Column(verticalArrangement = Arrangement.spacedBy(2.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    
                    if (title1 == "") {
                        Text(
                            text = title2,
                            style = MaterialTheme.typography.titleLarge,
                            color = colorResource(id = R.color.white)
                        )
                    } else {
                        Text(
                            text = title1,
                            style = MaterialTheme.typography.titleSmall,
                            color = colorResource(id = R.color.white)
                        )

                        Text(
                            text = title2,
                            style = MaterialTheme.typography.titleLarge,
                            color = colorResource(id = R.color.white)
                        )
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCard() {
    ManagementCardButtons("Test", "Test2", "")
}