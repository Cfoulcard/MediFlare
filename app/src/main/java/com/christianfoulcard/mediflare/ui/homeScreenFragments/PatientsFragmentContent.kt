package com.christianfoulcard.mediflare.ui.homeScreenFragments

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.christianfoulcard.mediflare.R
import com.christianfoulcard.mediflare.composables.Text
import com.christianfoulcard.mediflare.models.PatientCardData
import com.christianfoulcard.mediflare.models.PatientStatusOrCare
import com.christianfoulcard.mediflare.ui.viewmodels.PatientViewModel
import com.christianfoulcard.mediflare.utils.DateUtil


@Composable
fun PatientsFragmentContent() {

    val viewModel: PatientViewModel = viewModel()
    val filteredPatients = viewModel.filteredPatients.value
    var isDrawerOpen by remember { mutableStateOf(false) }
    var selectedPatient by remember { mutableStateOf<PatientCardData?>(null) }

    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.85F)
            ) {
                Spacer(Modifier.padding(32.dp))
                Text.FragmentTitle(stringResource(id = R.string.patient_title), Modifier.fillMaxWidth())
                Spacer(Modifier.padding(16.dp))
                SearchPatientTextField(viewModel)
                Spacer(Modifier.padding(16.dp))
                LazyColumn {
                    items(filteredPatients.size) { patient ->
                        PatientCard(filteredPatients[patient]) {
                            isDrawerOpen = true
                            selectedPatient = filteredPatients[patient]
                        }
                    }
                }
            }
        }
        selectedPatient?.let { PatientInfoDialog(isDrawerOpen, it) { isDrawerOpen = false } }
    }
}

@Composable
fun PatientInfoDialog(isDrawerOpen: Boolean, patient: PatientCardData, onDismiss: () -> Unit) {
    if (isDrawerOpen) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(dismissOnBackPress = true,
                dismissOnClickOutside = true,
                usePlatformDefaultWidth = false)) {
            PatientInfoView(patient)
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SearchPatientTextField(
    viewModel: PatientViewModel,
) {
    var isFocused by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    OutlinedTextField(
        value = searchQuery,
        onValueChange = {
            searchQuery = it
            viewModel.searchPatientsByNameOrId(searchQuery)
        },
        placeholder = { Text(stringResource(R.string.patient_search)) },
        modifier = Modifier
            .fillMaxWidth(1F)
            .border(
                width = 2.dp,
                color = if (isFocused) colorResource(R.color.logo_blue)
                else colorResource(R.color.dark_gray), shape = RoundedCornerShape(100.dp)
            )
            .clip(shape = RoundedCornerShape(100.dp))
            .onFocusChanged { isFocused = it.isFocused }
    )
}

@Composable
fun PatientCard(patient: PatientCardData, onClick: () -> Unit) {

    val gradientBrushInCare = Brush.horizontalGradient(
        colors = listOf(
            colorResource(id = R.color.gradient_dark_blue),  // Start color
            colorResource(id = R.color.gradient_light_blue)   // End color
        )
    )

    val gradientBrushAwaitingCare = Brush.horizontalGradient(
        colors = listOf(
            colorResource(id = R.color.gradient_dark_pink),  // Start color
            colorResource(id = R.color.gradient_light_pink)   // End color
        )
    )

    val gradientBrushCleared = Brush.horizontalGradient(
        colors = listOf(
            colorResource(id = R.color.gradient_dark_green),  // Start color
            colorResource(id = R.color.gradient_light_green)   // End color
        )
    )

    val gradientBrushAttendingStaff = Brush.horizontalGradient(
        colors = listOf(
            colorResource(id = R.color.gradient_dark_purple),  // Start color
            colorResource(id = R.color.gradient_light_purple)   // End color
        )
    )

    val gradient = when (patient.statusOrCaredForBy) {
        is PatientStatusOrCare.Status -> gradientBrushInCare
        is PatientStatusOrCare.AttendingStaff -> gradientBrushAttendingStaff
        is PatientStatusOrCare.Cleared -> gradientBrushCleared
        is PatientStatusOrCare.AwaitingCare -> gradientBrushAwaitingCare
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable(onClick = { onClick() })
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = gradient)
                .padding(12.dp),
        ) {

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(
                        text = patient.patientName,
                        style = MaterialTheme.typography.titleSmall,
                        color = colorResource(id = R.color.white)
                    )

                    Text(
                        text = "Illness: ${patient.illnessDiagnosis}",
                        style = MaterialTheme.typography.bodySmall,
                        color = colorResource(id = R.color.white)
                    )

                    Text(
                        text = when (val statusOrCare = patient.statusOrCaredForBy) {
                            is PatientStatusOrCare.Status -> statusOrCare.statusUpdate
                            is PatientStatusOrCare.AttendingStaff -> statusOrCare.staffName
                            is PatientStatusOrCare.Cleared -> statusOrCare.clearedBy
                            is PatientStatusOrCare.AwaitingCare -> statusOrCare.awaitingCare},
                        style = MaterialTheme.typography.bodySmall,
                        color = colorResource(id = R.color.white)
                    )
                }

                Text(
                    text = "ID: ${patient.patientId}",
                    style = MaterialTheme.typography.titleSmall,
                    color = colorResource(id = R.color.white),
                    modifier = Modifier.align(Alignment.Top)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientInfoView(patient: PatientCardData) {
    // Calculate the desired height
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val desiredHeight = screenHeight * 0.85f

    ModalNavigationDrawer(
        modifier = Modifier
            .fillMaxWidth()
            .height(desiredHeight),
        scrimColor = Color.Black.copy(alpha = 0.75f),
        drawerContent = { /* Empty content here */ },

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(desiredHeight)
                .clip(RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp)),
            contentAlignment = Alignment.TopCenter
        ) {
            ModalDrawerSheet(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.TopCenter),
                drawerShape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(Modifier.padding(16.dp))
                    Text.FragmentTitle(patient.patientName)

                    Column(horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(start = LocalConfiguration.current.screenWidthDp.dp * 0.10F)
                    ) {
                        Spacer(Modifier.padding(16.dp))
                        Text(text = "ID: ${patient.patientId}")
                        Text(text = "Age: ${patient.age}")
                        Text(text = "Admission Date: ${DateUtil().formatDate(patient.admissionDate)}")
                        Text(text = "Last Updated: ${DateUtil().formatDate(patient.lastUpdated)}")
                        Text(text = "Diagnosis: ${patient.illnessDiagnosis}")
                        Text(text = when (val statusOrCare = patient.statusOrCaredForBy) {
                            is PatientStatusOrCare.Status -> statusOrCare.statusUpdate
                            is PatientStatusOrCare.AttendingStaff -> statusOrCare.staffName
                            is PatientStatusOrCare.Cleared -> statusOrCare.clearedBy
                            is PatientStatusOrCare.AwaitingCare -> statusOrCare.awaitingCare})
                        Spacer(Modifier.padding(16.dp))
                        Text(text = "Vital Signs:")
                        Text(text = "•\t Temperature: ${patient.vitalSigns?.temperature}")
                        Text(text = "•\t Heart Rate: ${patient.vitalSigns?.heartRate}")
                        Text(text = "•\t Blood Pressure: ${patient.vitalSigns?.bloodPressure}")
                        Text(text = "•\t Respiratory Rate: ${patient.vitalSigns?.respiratoryRate}")
                        Text(text = "•\t Oxygen Saturation: ${patient.vitalSigns?.oxygenSaturation}")
                        Spacer(Modifier.padding(16.dp))
                        Text(text = "Treatment Plan:")
                        Text(text = "Medications:")
                        Text(text = "•\t Name: ${patient.treatmentPlan.antibiotics.name}")
                        Text(text = "•\t Dosage: ${patient.treatmentPlan.antibiotics.dosage}")
                        Text(text = "•\t Frequency: ${patient.treatmentPlan.antibiotics.frequency}")
                    }
                }
            }
        }
    }
}



    @Preview(showBackground = true)
@Composable
fun PreviewPatientScreen() {
    PatientsFragmentContent()
}