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

val vitalSignsFourthPatient = VitalSigns(
    temperature = 98.6F,
    heartRate = 76,
    bloodPressure = "110/80 mmHg",
    respiratoryRate = 20,
    oxygenSaturation = 98
)

val vitalSignsFifthPatient = VitalSigns(
    temperature = 98.6F,
    heartRate = 82,
    bloodPressure = "145/95 mmHg",
    respiratoryRate = 18,
    oxygenSaturation = 98
)

val vitalSignsCAD = VitalSigns(
    temperature = 98.4F,
    heartRate = 88,
    bloodPressure = "130/85 mmHg",
    respiratoryRate = 18,
    oxygenSaturation = 97
)

val vitalSignsRA = VitalSigns(
    temperature = 99.1F,
    heartRate = 75,
    bloodPressure = "120/80 mmHg",
    respiratoryRate = 20,
    oxygenSaturation = 98
)

val vitalSignsTuberculosis = VitalSigns(
    temperature = 101.5F,
    heartRate = 90,
    bloodPressure = "115/75 mmHg",
    respiratoryRate = 22,
    oxygenSaturation = 95
)

val vitalSignsFlu = VitalSigns(
    temperature = 102.2F,
    heartRate = 95,
    bloodPressure = "115/75 mmHg",
    respiratoryRate = 23,
    oxygenSaturation = 96
)

val vitalSignsCOPD = VitalSigns(
    temperature = 98.6F,
    heartRate = 82,
    bloodPressure = "120/80 mmHg",
    respiratoryRate = 24,
    oxygenSaturation = 90
)

val vitalSignsOsteoporosis = VitalSigns(
    temperature = 98.6F,
    heartRate = 76,
    bloodPressure = "110/80 mmHg",
    respiratoryRate = 20,
    oxygenSaturation = 98
)

val vitalSignsBackPain = VitalSigns(
    temperature = 98.6F,
    heartRate = 76,
    bloodPressure = "110/80 mmHg",
    respiratoryRate = 20,
    oxygenSaturation = 98
)
