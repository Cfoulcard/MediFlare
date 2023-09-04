package com.christianfoulcard.mediflare.ui.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.christianfoulcard.MediFlare.Companion.globalAppContext
import com.christianfoulcard.mediflare.R
import com.christianfoulcard.mediflare.models.StatusCardData
import com.christianfoulcard.mediflare.ui.homeScreenFragments.StatusCard


class DashboardViewModel() : ViewModel() {

        /** Initializes the card list */
        private val initialStatusCards = listOf(
            StatusCardData("1", globalAppContext.getString(R.string.total_admissions), "34"),
             StatusCardData("2", globalAppContext.getString(R.string.total_patients),"27"),
             StatusCardData("3", globalAppContext.getString(R.string.bed_occupancy_rate),"49%"),
             StatusCardData("4", globalAppContext.getString(R.string.vehicles_in_use),"3"),
             StatusCardData("5", globalAppContext.getString(R.string.lab_test_results),"7"),
             StatusCardData("6", globalAppContext.getString(R.string.surgeries_in_queue),"1"),
             StatusCardData("7", globalAppContext.getString(R.string.average_waiting_time),"5 mins"),
             StatusCardData("8", globalAppContext.getString(R.string.pss),"9"),
             StatusCardData("9", globalAppContext.getString(R.string.rx_comp_rate),"67%"),
             StatusCardData("10", globalAppContext.getString(R.string.staff_patient_ratio),"3:1"),
             StatusCardData("11", globalAppContext.getString(R.string.diagnosis_ar),"95%"),
             StatusCardData("12", globalAppContext.getString(R.string.rx_error_rate),"5%"),
        )

    private val _statusCards = mutableStateOf(initialStatusCards)
    val statusCards: State<List<StatusCardData>> = _statusCards

    fun sortStatusCards() {
        _statusCards.value = _statusCards.value.sortedBy { it.id }
    }

    fun resetStatusCards() {
        _statusCards.value = initialStatusCards
    }

    }
