package com.christianfoulcard.mediflare.models

import com.christianfoulcard.mediflare.utils.DateUtil
import java.util.Date

/**
 * For this app, this is our main data class we'll use. The values are
 * a mix of primitive fields, other data classes, and sealed classes
 *
 * In a real world scenario we'd use an API get/post method for
 * filling data in the app or pushing data to the server
 * */
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
    val vitalSigns: VitalSigns?,
    val treatmentPlan: TreatmentPlan
)

val firstPatientCard = PatientCardData(
    "1",
    "PT123456",
    "James Anderson",
    "Pneumonia",
    PatientStatusOrCare.AttendingStaff("Sarah Thompson"),
    45,
    "Male",
    DateUtil().randomDateFromToday(),
    DateUtil().randomDateFromTodayPlusXMinutes(),
    "Stable",
    vitalSignsFirstPatient,
    treatmentPlanFirstPatient
)

val secondPatientCard = PatientCardData(
    "2",
    "PT654321",
    "Emily Roberts",
    "Bronchitis",
    PatientStatusOrCare.AttendingStaff("Karl Rock"),
    32,
    "Female",
    DateUtil().randomDateFromToday(),
    DateUtil().randomDateFromTodayPlusXMinutes(),
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
    DateUtil().randomDateFromToday(),
    DateUtil().randomDateFromTodayPlusXMinutes(),
    "Critical",
    vitalSignsThirdPatient,
    treatmentPlanThirdPatient
)

val fourthPatientCard = PatientCardData(
    "4",
    "PT928472",
    "Kyle Salvador",
    "Common Cold",
    PatientStatusOrCare.AwaitingCare(),
    25,
    "Male",
    DateUtil().randomDateFromToday(),
    DateUtil().randomDateFromTodayPlusXMinutes(),
    "Stable",
    vitalSignsFourthPatient,
    treatmentPlanFourthPatient
)

val fifthPatientCard = PatientCardData(
    "5",
    "PT938294",
    "Alice Johnson",
    "Hypertension",
    PatientStatusOrCare.Status("Status: Stable but Tired"),
    55,
    "Female",
    DateUtil().randomDateFromToday(),
    DateUtil().randomDateFromTodayPlusXMinutes(),
    "Stable",
    vitalSignsFifthPatient,
    treatmentPlanHypertension
)

val sixthPatientCard = PatientCardData(
    "6",
    "PT103827",
    "Robert Jones",
    "Coronary Artery Disease",
    PatientStatusOrCare.AwaitingCare(),
    63,
    "Male",
    DateUtil().randomDateFromToday(),
    DateUtil().randomDateFromTodayPlusXMinutes(),
    "Stable",
    vitalSignsCAD,
    treatmentPlanCAD
)

val seventhPatientCard = PatientCardData(
    "7",
    "PT987564",
    "Emma Brown",
    "Rheumatoid Arthritis",
    PatientStatusOrCare.Cleared("Cleared by Lisa Silverlake"),
    71,
    "Female",
    DateUtil().randomDateFromToday(),
    DateUtil().randomDateFromTodayPlusXMinutes(),
    "Stable",
    vitalSignsRA,
    treatmentPlanRA
)

val eightPatientCard = PatientCardData(
    "8",
    "PT183627",
    "Maria Davis",
    "Tuberculosis",
    PatientStatusOrCare.Cleared("Cleared by Devin Paul"),
    29,
    "Female",
    DateUtil().randomDateFromToday(),
    DateUtil().randomDateFromTodayPlusXMinutes(),
    "Stable",
    vitalSignsTuberculosis,
    treatmentPlanTuberculosis
)

val ninthPatientCard = PatientCardData(
    "9",
    "PT283629",
    "William Willer",
    "Influenza (Flu)",
    PatientStatusOrCare.AwaitingCare(),
    26,
    "Male",
    DateUtil().randomDateFromToday(),
    DateUtil().randomDateFromTodayPlusXMinutes(),
    "Stable",
    vitalSignsFlu,
    treatmentPlanFlu
)

val tenthPatientCard = PatientCardData(
    "10",
    "PT271028",
    "Goldie Star",
    "COPD",
    PatientStatusOrCare.AwaitingCare(),
    59,
    "Female",
    DateUtil().randomDateFromToday(),
    DateUtil().randomDateFromTodayPlusXMinutes(),
    "Stable",
    vitalSignsCOPD,
    treatmentPlanCOPD
)

val eleventhPatientCard = PatientCardData(
    "11",
    "PT918268",
    "Austin Rock",
    "Osteoporosis",
    PatientStatusOrCare.AwaitingCare(),
    63,
    "Male",
    DateUtil().randomDateFromToday(),
    DateUtil().randomDateFromTodayPlusXMinutes(),
    "Stable",
    vitalSignsOsteoporosis,
    treatmentPlanOsteoporosis
)

val twelvethPatientCard = PatientCardData(
    "12",
    "PT826179",
    "Michael Crest",
    "Back Pain",
    PatientStatusOrCare.Status("Status: In pain"),
    37,
    "Male",
    DateUtil().randomDateFromToday(),
    DateUtil().randomDateFromTodayPlusXMinutes(),
    "Stable",
    vitalSignsBackPain,
    treatmentPlanBackPain
)
