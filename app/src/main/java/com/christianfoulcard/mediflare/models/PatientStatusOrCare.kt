package com.christianfoulcard.mediflare.models

sealed class PatientStatusOrCare {
    data class Status(val statusUpdate: String) : PatientStatusOrCare()
    data class AttendingStaff(val staffName: String) : PatientStatusOrCare()
}