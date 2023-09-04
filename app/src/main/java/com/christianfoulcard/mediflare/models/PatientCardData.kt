package com.christianfoulcard.mediflare.models

import java.util.Date

data class PatientCardData(
    val id: String,
    val patientId: String,
    val patientName: String,
    val illnessDiagnosis: String,
    val statusOrCaredForBy: String,
    val age: Int,
    val gender: String,
    val admissionDate: Date?,
    val lastUpdated: Date?,
    val state: String,
)

val firstPatientCard = PatientCardData(
    "1",
    "PT123456",
    "James Anderson",
    "Pneumonia",
    "Sarah Thompson",
    45,
    "Male",
    null,
    null,
    "Stable"
)

val secondPatientCard = PatientCardData(
    "2",
    "PT654321",
    "Emily Roberts",
    "Bronchitis",
    "John Miller",
    32,
    "Female",
    null,
    null,
    "Under Observation"
)

val thirdPatientCard = PatientCardData(
    "3",
    "PT789012",
    "Michael Brown",
    "Asthma",
    "Nancy Wilson",
    50,
    "Male",
    null,
    null,
    "Critical"
)