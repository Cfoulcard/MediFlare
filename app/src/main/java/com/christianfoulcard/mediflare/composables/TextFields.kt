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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object TextFields {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun UsernameAndEmailTextField(modifier: Modifier = Modifier) {

        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            placeholder = { Text("Email / Username") },  // Optional, visible when the field is empty
                    onValueChange = { text = it },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Black,  // Adjust as needed
                unfocusedIndicatorColor = Color.Black  // Adjust as needed
            ),
            modifier = modifier
                .fillMaxWidth(0.75F)
                .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(100.dp))  // Adjust border width and color as needed
                .clip(shape = RoundedCornerShape(100.dp)))
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PasswordTextField(modifier: Modifier = Modifier) {

        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            placeholder = { Text("Password") },  // Optional, visible when the field is empty
            onValueChange = { text = it },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Black,  // Adjust as needed
                unfocusedIndicatorColor = Color.Black  // Adjust as needed
            ),
            modifier = modifier
                .fillMaxWidth(0.75F)
                .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(100.dp))  // Adjust border width and color as needed
                .clip(shape = RoundedCornerShape(100.dp)))
    }

}