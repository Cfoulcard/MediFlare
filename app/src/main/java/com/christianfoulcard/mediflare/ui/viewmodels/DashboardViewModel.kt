package com.christianfoulcard.mediflare.ui.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.christianfoulcard.MediFlare
import com.christianfoulcard.mediflare.R
import com.christianfoulcard.mediflare.models.StatusCardData


class DashboardViewModel() : ViewModel() {

        /** Initializes the card list */
        val initialStatusCards = listOf(
            StatusCardData("1",  MediFlare.getAppContext().getString(R.string.total_admissions), "34"),
             StatusCardData("2", MediFlare.getAppContext().getString(R.string.total_patients),"27"),
             StatusCardData("3", MediFlare.getAppContext().getString(R.string.bed_occupancy_rate),"49%"),
             StatusCardData("4", MediFlare.getAppContext().getString(R.string.vehicles_in_use),"3"),
             StatusCardData("5", MediFlare.getAppContext().getString(R.string.lab_test_results),"7"),
             StatusCardData("6", MediFlare.getAppContext().getString(R.string.surgeries_in_queue),"1"),
             StatusCardData("7", MediFlare.getAppContext().getString(R.string.average_waiting_time),"5 mins"),
             StatusCardData("8", MediFlare.getAppContext().getString(R.string.pss),"9"),
             StatusCardData("9", MediFlare.getAppContext().getString(R.string.rx_comp_rate),"67%"),
             StatusCardData("10", MediFlare.getAppContext().getString(R.string.staff_patient_ratio),"3:1"),
             StatusCardData("11", MediFlare.getAppContext().getString(R.string.diagnosis_ar),"95%"),
             StatusCardData("12", MediFlare.getAppContext().getString(R.string.rx_error_rate),"5%"),
        )

    val _statusCards = mutableStateOf(initialStatusCards)
    val statusCards: State<List<StatusCardData>> = _statusCards

    /**
     * Sorts the list of status cards in ascending order based on their unique identifiers (IDs).
     * This function updates the [_statusCards] mutable state to reflect the sorted order.
     */
    fun sortStatusCards() {
        _statusCards.value = _statusCards.value.sortedBy { it.id }
    }

    /**
     * Resets the list of status cards to its initial state.
     * This function restores the [_statusCards] mutable state to its original content,
     * effectively undoing any changes made to the list.
     */
    fun resetStatusCards() {
        _statusCards.value = initialStatusCards
    }

    }
