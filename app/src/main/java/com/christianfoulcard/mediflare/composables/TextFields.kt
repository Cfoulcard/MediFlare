package com.christianfoulcard.mediflare.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.christianfoulcard.mediflare.R

object TextFields {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun UsernameAndEmailTextField(modifier: Modifier = Modifier) {

        var text by remember { mutableStateOf("") }
        var isFocused by remember { mutableStateOf(false) }

        OutlinedTextField(
            value = text,
            placeholder = { Text(stringResource(R.string.email_username)) },
                    onValueChange = { text = it },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Black
            ),
            modifier = modifier
                .fillMaxWidth(0.75F)
                .border(
                    width = 2.dp,
                    color = if (isFocused) colorResource(R.color.logo_blue)
                    else colorResource(R.color.dark_gray), shape = RoundedCornerShape(100.dp)
                )
                .clip(shape = RoundedCornerShape(100.dp))
                .onFocusChanged { isFocused = it.isFocused })
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PasswordTextField(modifier: Modifier = Modifier) {

        var text by remember { mutableStateOf("") }
        var isFocused by remember { mutableStateOf(false) }

        OutlinedTextField(
            value = text,
            placeholder = { Text(stringResource(R.string.password)) },
            onValueChange = { text = it },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Black
            ),
            modifier = modifier
                .fillMaxWidth(0.75F)
                .border(
                    width = 2.dp,
                    color = if (isFocused) colorResource(R.color.logo_blue)
                    else colorResource(R.color.dark_gray), shape = RoundedCornerShape(100.dp)
                )
                .clip(shape = RoundedCornerShape(100.dp))
                .onFocusChanged { isFocused = it.isFocused })
    }

}