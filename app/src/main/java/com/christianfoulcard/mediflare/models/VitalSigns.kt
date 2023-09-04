package com.christianfoulcard.mediflare.models

data class VitalSigns(
    val temperature: Float, // in °F
    val heartRate: Int,    // in bpm
    val bloodPressure: String, // format "XXX/XX mmHg"
    val respiratoryRate: Int,  // in bpm
    val oxygenSaturation: Int  // in percentage
)

val vitalSignsFirstPatient = VitalSigns(
    temperature = 99.2F,
    heartRate = 85,
    bloodPressure = "120/80 mmHg",
    respiratoryRate = 18,
    oxygenSaturation = 95
)

val vitalSignsSecondPatient = VitalSigns(
    temperature = 99.8F,
    heartRate = 88,
    bloodPressure = "120/80 mmHg",
    respiratoryRate = 20,
    oxygenSaturation = 97
)

val vitalSignsThirdPatient = VitalSigns(
    temperature = 98.6F,
    heartRate = 100,
    bloodPressure = "130/85 mmHg",
    respiratoryRate = 25,
    oxygenSaturation = 90
)