package com.christianfoulcard.mediflare.models

import java.util.Date

data class PatientCardData(
    val id: String,
    val patientId: String,
    val patientName: String,
    val illnessDiagnosis: String,
    val statusOrCaredForBy: PatientStatusOrCare,
    val age: Int,
    val gender: String,
    val admissionDate: Date?,
    val lastUpdated: Date?,
    val state: String,
    val vitalSigns: VitalSigns?, // This can be nullable if not all patients have vital signs recorded,
    val treatmentPlan: TreatmentPlan
)

val firstPatientCard = PatientCardData(
    "1",
    "PT123456",
    "James Anderson",
    "Pneumonia",
    PatientStatusOrCare.AttendingStaff("In the care of Sarah Thompson"),
    45,
    "Male",
    null,
    null,
    "Stable",
    vitalSignsFirstPatient,
    treatmentPlanFirstPatient
)

val secondPatientCard = PatientCardData(
    "2",
    "PT654321",
    "Emily Roberts",
    "Bronchitis",
    PatientStatusOrCare.AttendingStaff("In the care of Karl Rock"),
    32,
    "Female",
    null,
    null,
    "Under Observation",
    vitalSignsSecondPatient,
    treatmentPlanSecondPatient
)

val thirdPatientCard = PatientCardData(
    "3",
    "PT789012",
    "Michael Brown",
    "Asthma",
    PatientStatusOrCare.Status("Status: Stable"),
    50,
    "Male",
    null,
    null,
    "Critical",
    vitalSignsThirdPatient,
    treatmentPlanThirdPatient
)