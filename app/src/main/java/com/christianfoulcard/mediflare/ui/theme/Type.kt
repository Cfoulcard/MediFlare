package com.christianfoulcard.mediflare.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.christianfoulcard.mediflare.R

val LatoBlack = FontFamily(Font(R.font.lato_black))
val LatoBlackItalic = FontFamily(Font(R.font.lato_black_italic))
val LatoBold = FontFamily(Font(R.font.lato_bold))
val LatoBoldItalic = FontFamily(Font(R.font.lato_bold_italic))
val LatoRegular = FontFamily(Font(R.font.lato_regular))
val LatoLight = FontFamily(Font(R.font.lato_light))
val LatoLightItalic = FontFamily(Font(R.font.lato_light_italic))
val LatoItalic = FontFamily(Font(R.font.lato_italic))
val LatoThin = FontFamily(Font(R.font.lato_thin))
val LatoThinItalic = FontFamily(Font(R.font.lato_thin_italic))


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = LatoRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = LatoBlack,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)