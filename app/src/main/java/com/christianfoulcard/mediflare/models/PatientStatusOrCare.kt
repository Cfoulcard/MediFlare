package com.christianfoulcard.mediflare.models

sealed class PatientStatusOrCare {
    data class Status(val statusUpdate: String) : PatientStatusOrCare()
    data class AttendingStaff(val staffName: String) : PatientStatusOrCare()
    data class Cleared(val clearedBy: String) : PatientStatusOrCare()
    data class AwaitingCare(val awaitingCare: String = "Awaiting Care") : PatientStatusOrCare()
}