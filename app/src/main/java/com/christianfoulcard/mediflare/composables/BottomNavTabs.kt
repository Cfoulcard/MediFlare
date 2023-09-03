package com.christianfoulcard.mediflare.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.christianfoulcard.mediflare.R
import com.christianfoulcard.mediflare.composables.BottomNavTabs.EvenlySpacedBottomNavigationBar

object BottomNavTabs {

    @Composable
    fun EvenlySpacedBottomNavigationBar() {
        // Keeping track of the selected tab
        var selectedTab by remember { mutableStateOf(1) }

        val items = listOf(
            R.drawable.address_card,
            R.drawable.fire_flame,
            R.drawable.laptop_medical_solid,
        )

        BottomAppBar(
            contentColor = Color.White,
            containerColor = Color.White
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                items.forEachIndexed { index, drawableResId ->
                    BottomNavigationItem(
                        iconResId = drawableResId,
                        isSelected = selectedTab == index,
                        onSelected = { selectedTab = index },
                        modifier = Modifier.weight(1f), // This ensures each item is evenly spaced
                        inactiveColor = colorResource(id = R.color.light_gray),
                        activeColor = colorResource(id = R.color.logo_blue)
                    )
                }
            }
        }

    }

    @Composable
    fun BottomNavigationItem(
        iconResId: Int,
        isSelected: Boolean,
        onSelected: () -> Unit,
        activeColor: Color,
        inactiveColor: Color,
        modifier: Modifier
    ) {
        Column(
            modifier = modifier.clickable { onSelected() },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        if (isSelected) activeColor.copy(alpha = 0.0f) else Color.Transparent,
                        shape = RoundedCornerShape(28.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = iconResId),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(if (isSelected) activeColor else inactiveColor)
                )
            }

            Spacer(modifier = Modifier.height(8.dp)) // Space between icon and line

            if (isSelected) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(4.dp)
                        .background(activeColor, shape = RoundedCornerShape(100.dp))
                )
            }
        }
    }
}


    @Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    EvenlySpacedBottomNavigationBar()
}