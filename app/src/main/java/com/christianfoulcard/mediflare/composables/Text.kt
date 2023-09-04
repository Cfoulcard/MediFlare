package com.christianfoulcard.mediflare.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.christianfoulcard.mediflare.R

object Text {

    @Composable
    fun FragmentTitle(title: String, modifier: Modifier = Modifier) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = title,
                color = colorResource(id = R.color.dark_gray),
                textAlign = TextAlign.Center,
                lineHeight = 5.85.em,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Black
                ),
                modifier = modifier
            )
        }
    }

}