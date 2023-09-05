package com.christianfoulcard.mediflare.composables

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.christianfoulcard.MediFlare.Companion.globalAppContext
import com.christianfoulcard.mediflare.R
import com.christianfoulcard.mediflare.models.PatientCardData
import com.christianfoulcard.mediflare.models.PatientStatusOrCare
import com.christianfoulcard.mediflare.ui.HomeScreenActivity
import com.christianfoulcard.mediflare.ui.LoginScreenActivity

object Buttons {

    @Composable
    fun LoginButton(context: Context, activity: Activity) {
        Button(
            onClick = {
                activity.startActivity(Intent(context, HomeScreenActivity::class.java))
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
                      Toast.makeText(globalAppContext, "$string's phone has received a ping from you", LENGTH_SHORT).show()
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
}