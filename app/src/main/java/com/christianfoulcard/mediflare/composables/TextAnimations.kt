package com.christianfoulcard.mediflare.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.christianfoulcard.mediflare.ui.theme.LatoBlack
import kotlinx.coroutines.delay

object TextAnimations {

    @Composable
    fun AnimatedTextCompose() {
        var animatedText by remember { mutableStateOf("") }
        var isDeleting by remember { mutableStateOf(false) }
        val textList = listOf("Hello", "World", "Compose")
        var textIndex by remember { mutableStateOf(0) }

        LaunchedEffect(Unit) {
            while (true) {
                if (isDeleting) {
                    if (animatedText.isNotEmpty()) {
                        animatedText = animatedText.dropLast(1)
                        delay(100)  // Speed of deleting
                    } else {
                        isDeleting = false
                        textIndex = (textIndex + 1) % textList.size  // Move to next text or wrap around
                    }
                } else {
                    if (animatedText != textList[textIndex]) {
                        animatedText = textList[textIndex].substring(0, animatedText.length + 1)
                        delay(200)  // Speed of typing
                    } else {
                        delay(1000)  // Delay after complete word
                        isDeleting = true
                    }
                }
            }
        }

        Text(text = animatedText, fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }

    @Composable
    fun LoadingTextAnimation() {
        val dotCount = animatedDotCount()

        val maxDotCount = 3 // Maximum number of dots you expect

        val loadingText = buildString {
            append("Logging In")
            append(".".repeat(dotCount))
            repeat(maxDotCount - dotCount) {
                append(" ")
            }
        }

        Text(
            text = loadingText,
            fontSize = 24.sp,
            fontFamily = LatoBlack,

        )
    }

    @Composable
    fun animatedDotCount(): Int {
        val dotState = remember { mutableStateOf(1) }
        LaunchedEffect(Unit) {
            while (true) {
                delay(500) // Change delay as required
                dotState.value = (dotState.value % 3) + 1
            }
        }
        return dotState.value
    }



}
