package com.christianfoulcard.mediflare.composables

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.christianfoulcard.mediflare.R
import com.christianfoulcard.mediflare.composables.TextAnimations.LoadingTextAnimation

object Images {

    @Composable
    fun AnimatedLogoAlphaImageFullScreen() {
        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.dp
        val screenHeight = configuration.screenHeightDp.dp

        val mediFlareLogo = painterResource(id = R.drawable.mediflare_logo)

        val infiniteTransition = rememberInfiniteTransition(label = "MediaFlare Animation")
        val alpha by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(2000, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ), label = "MediaFlare Alpha"
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = mediFlareLogo,
                contentDescription = "MediFlare Logo Fade Animation",
                modifier = Modifier.size(width = screenWidth / 2, height = screenHeight / 2).alpha(alpha),
                contentScale = ContentScale.Fit)
        }
    }

    @Composable
    fun AnimatedLogoAlphaImageFullScreenLoading() {
        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.dp
        val screenHeight = configuration.screenHeightDp.dp

        val mediFlareLogo = painterResource(id = R.drawable.mediflare_logo)

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = mediFlareLogo,
                    contentDescription = "MediFlare Logo Fade Animation",
                    modifier = Modifier.wrapContentSize(),
                    contentScale = ContentScale.Fit
                )
                LoadingTextAnimation()
            }
        }
    }




    @Composable
    fun MediFlareLogoFullScreen() {

        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.dp
        val screenHeight = configuration.screenHeightDp.dp

        val mediFlareLogo = painterResource(id = R.drawable.mediflare_logo)

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(width = screenWidth / 2, height = screenHeight / 2),
                contentScale = ContentScale.Fit,
                painter = mediFlareLogo,
                contentDescription = "MediFlare Logo",
            )
        }

    }

    @Composable
    fun MediFlareLogo() {

        val mediFlareLogo = painterResource(id = R.drawable.mediflare_logo)

            Image(
                modifier = Modifier.fillMaxWidth(1F),
                painter = mediFlareLogo,
                contentDescription = "MediFlare Logo",
            )

        }


}