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

    /**
     * An initial list of patient card objects representing patient data.
     * This list contains predefined patient card objects, each encapsulating
     * information about individual patients, such as names, IDs, and medical details.
     * It serves as the starting dataset for patient-related operations in the application.
     */
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

    /**
     * A mutable state holder for the list of patients that have been filtered based on a search query.
     * This variable holds a dynamic, observable list of patients that can be updated and observed within
     * the Composable UI.
     */
    var filteredPatients = mutableStateOf(_patients)

    /**
     * Searches for patients in the dataset by their name or ID, filtering the results based on the provided query.
     *
     * @param query The search query to filter patients by name or ID.
     */
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