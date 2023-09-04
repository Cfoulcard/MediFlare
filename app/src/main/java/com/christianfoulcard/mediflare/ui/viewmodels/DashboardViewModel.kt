package com.christianfoulcard.mediflare.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


    class DashboardViewModel : ViewModel() {

        var count by mutableIntStateOf(0)
            private set

        fun incrementCount() {
            count++
        }
    }
