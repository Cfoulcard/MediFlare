package com.christianfoulcard.mediflare.ui.homeScreenFragments

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.christianfoulcard.mediflare.R
import com.christianfoulcard.mediflare.composables.Text
import com.christianfoulcard.mediflare.models.PatientCardData
import com.christianfoulcard.mediflare.ui.viewmodels.PatientViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientsFragmentContent() {

    val viewModel: PatientViewModel = viewModel()
    val filteredPatients = viewModel.filteredPatients.value


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

                LazyColumn {
                    items(filteredPatients.size) { patient ->
                        PatientCard(filteredPatients[patient])
                    }

                }
            }
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
fun PatientCard(patient: PatientCardData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Text(text = patient.patientName)
        Text(text = patient.illnessDiagnosis)
        Text(text = patient.statusOrCaredForBy)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPatientScreen() {
    PatientsFragmentContent()
}