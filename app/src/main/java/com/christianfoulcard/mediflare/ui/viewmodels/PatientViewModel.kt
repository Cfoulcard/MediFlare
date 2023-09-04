package com.christianfoulcard.mediflare.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.christianfoulcard.mediflare.models.firstPatientCard
import com.christianfoulcard.mediflare.models.secondPatientCard
import com.christianfoulcard.mediflare.models.thirdPatientCard


class PatientViewModel: ViewModel() {

    private var _patients = listOf(firstPatientCard, secondPatientCard, thirdPatientCard)
    var filteredPatients = mutableStateOf(_patients)

    fun searchPatientsByNameOrId(query: String) {
        filteredPatients.value = if (query.isEmpty()) {
            _patients
        } else {
            _patients.filter {
                it.patientName.contains(query, ignoreCase = true) ||
                        it.patientId.contains(query, ignoreCase = true)
            }
        }
    }


}