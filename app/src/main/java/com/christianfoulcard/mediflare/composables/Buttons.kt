package com.christianfoulcard.mediflare.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object Buttons {

    @Composable
    fun LoginButton(modifier: Modifier = Modifier) {
        Button(
            onClick = { },
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff00597e)),
            modifier = modifier
                .fillMaxWidth(0.75F)
                .height(60.dp))
        { Text(text = "Login") }
    }
}