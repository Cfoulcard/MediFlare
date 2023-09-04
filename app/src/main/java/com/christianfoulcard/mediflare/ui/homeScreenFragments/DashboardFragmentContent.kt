package com.christianfoulcard.mediflare.ui.homeScreenFragments

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.christianfoulcard.mediflare.R
import com.christianfoulcard.mediflare.composables.Text.FragmentTitle
import com.christianfoulcard.mediflare.ui.viewmodels.DashboardViewModel

@Composable
fun DashboardFragmentContent() {

    val viewModel: DashboardViewModel = viewModel()

    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.85F)
            ) {
                Spacer(Modifier.padding(32.dp))
                WelcomeCard()
                Spacer(Modifier.padding(16.dp))
                FragmentTitle(stringResource(id = R.string.current_status), Modifier.fillMaxWidth())
                Spacer(Modifier.padding(16.dp))
                StatusCardGrid()
            }
        }
    }
}

@Composable
fun WelcomeCard(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white)
        ),
        modifier = modifier
            .fillMaxWidth(1F)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color.White)
            .border(width = 2.dp, color = colorResource(id = R.color.dark_gray), shape = RoundedCornerShape(20.dp))
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "Welcome back, Doctor Russell\n" +
                    "\n" +
                    "As the Chief Medical Officer, your expertise and leadership are pivotal. Currently, Trinity Medical Center is experiencing a surge in patient activity, with over 21 patients receiving exceptional care.\n" +
                    "\n",
                color = colorResource(id = R.color.dark_gray),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
                )
        }
    }
}

@Composable
fun StatusCardGrid() {

    val statusCards by remember { mutableStateOf(listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12")) }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        modifier = Modifier.padding(horizontal = 0.dp),
    ) {

        items(statusCards) { item ->
            when (item) {
                "1" -> {
                    StatusCard(stringResource(R.string.total_admissions),"34")
                }
                "2" -> {
                    StatusCard(stringResource(R.string.total_patients),"27")
              }
                "3" -> {
                    StatusCard(stringResource(R.string.bed_occupancy_rate),"49%")
                }
                "4" -> {
                    StatusCard(stringResource(R.string.vehicles_in_use),"3")
                }
                "5" -> {
                    StatusCard(stringResource(R.string.lab_test_results),"7")
                }
                "6" -> {
                    StatusCard(stringResource(R.string.surgeries_in_queue),"1")
                }
                "7" -> {
                    StatusCard(stringResource(R.string.average_waiting_time),"5 mins")
                }
                "8" -> {
                    StatusCard(stringResource(R.string.pss),"9")
                }
                "9" -> {
                    StatusCard(stringResource(R.string.rx_comp_rate),"67%")
                }
                "10" -> {
                    StatusCard(stringResource(R.string.staff_patient_ratio),"3:1")
                }
                "11" -> {
                    StatusCard(stringResource(R.string.diagnosis_ar),"95%")
                }
                "12" -> {
                    StatusCard(stringResource(R.string.rx_error_rate),"5%")
                }
                else -> {

                }
            }

        }
    }
}

@Composable
fun StatusCard(title: String, count: String) {
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
            colorResource(id = R.color.gradient_light_blue),   // Start color
            colorResource(id = R.color.gradient_dark_blue)  // End color
        )
    )

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(1f)
            .size(100.dp)
    ) {
        Box(
            contentAlignment = Alignment.BottomStart,
            modifier = Modifier
                .fillMaxSize()
                .background(brush = gradientBrush)
                .padding(8.dp),
            ) {
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.bodyLarge,
                    color = colorResource(id = R.color.white)
                )
                Text(
                    text = count,
                    fontSize = 24.sp,
                    style = MaterialTheme.typography.headlineMedium,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewDashboardScreen() {
    DashboardFragmentContent()
}
