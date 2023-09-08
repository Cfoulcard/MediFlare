package com.christianfoulcard.mediflare.ui.viewmodels

import com.christianfoulcard.mediflare.models.PatientCardData
import com.christianfoulcard.mediflare.models.firstPatientCard
import org.junit.Assert.*
import org.junit.Test

class PatientViewModelTest {

    private val viewModel = PatientViewModel()

    @Test
    fun search_patients_by_name_or_id_with_empty_query_should_return_all_patients() {
        viewModel.filteredPatients.value = viewModel._patients
        val emptyQuery = ""

        viewModel.searchPatientsByNameOrId(emptyQuery)

        val resultPatients = viewModel.filteredPatients.value
        val allPatients = viewModel._patients
        assertEquals(allPatients, resultPatients)
    }

    @Test
    fun search_patients_by_name_or_id_with_non_empty_query_should_filter_patients_by_name_or_id() {
        viewModel.filteredPatients.value = viewModel._patients
        val query = "James"

        viewModel.searchPatientsByNameOrId(query)

        val resultPatients = viewModel.filteredPatients.value
        val expectedPatients = listOf(
            firstPatientCard
        )
        assertEquals(expectedPatients, resultPatients)
    }
}