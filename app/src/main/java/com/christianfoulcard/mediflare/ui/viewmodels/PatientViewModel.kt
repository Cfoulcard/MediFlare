package com.christianfoulcard.mediflare.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.christianfoulcard.mediflare.models.eightPatientCard
import com.christianfoulcard.mediflare.models.eleventhPatientCard
import com.christianfoulcard.mediflare.models.fifthPatientCard
import com.christianfoulcard.mediflare.models.firstPatientCard
import com.christianfoulcard.mediflare.models.fourthPatientCard
import com.christianfoulcard.mediflare.models.ninthPatientCard
import com.christianfoulcard.mediflare.models.secondPatientCard
import com.christianfoulcard.mediflare.models.seventhPatientCard
import com.christianfoulcard.mediflare.models.sixthPatientCard
import com.christianfoulcard.mediflare.models.tenthPatientCard
import com.christianfoulcard.mediflare.models.thirdPatientCard
import com.christianfoulcard.mediflare.models.twelvethPatientCard


class PatientViewModel: ViewModel() {

    private var _patients = listOf(
        firstPatientCard,
        secondPatientCard,
        thirdPatientCard,
        fourthPatientCard,
        fifthPatientCard,
        sixthPatientCard,
        seventhPatientCard,
        eightPatientCard,
        ninthPatientCard,
        tenthPatientCard,
        eleventhPatientCard,
        twelvethPatientCard
    )

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