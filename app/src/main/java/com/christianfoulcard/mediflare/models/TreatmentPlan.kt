package com.christianfoulcard.mediflare.models

data class TreatmentPlan(
    val antibiotics: Medication,
    val respiratorySupport: RespiratorySupport,
    val mobility: Mobility
)

val treatmentPlanFirstPatient = TreatmentPlan(
    antibiotics = Medication(
        name = "Amoxicillin",
        dosage = "500mg",
        frequency = "every 8 hours"
    ),
    respiratorySupport = RespiratorySupport(
        method = "Nebulizer treatments",
        treatment = "with albuterol and saline, as prescribed"
    ),
    mobility = Mobility(
        description = "Assisted with turning and deep breathing exercises",
        frequency = "every 2 hours"
    )
)

val treatmentPlanSecondPatient = TreatmentPlan(
    antibiotics = Medication(
        name = "Amoxicillin",
        dosage = "500mg",
        frequency = "every 8 hours"
    ),
    respiratorySupport = RespiratorySupport(),
    mobility = Mobility(
        description = "Assisted with turning and deep breathing exercises",
        frequency = "every 2 hours"
    )
)

val treatmentPlanThirdPatient = TreatmentPlan(
    antibiotics = Medication(
        name = "None",
        dosage = "N/A",
        frequency = "N/A"
    ),
    respiratorySupport = RespiratorySupport(
        method = "Nebulizer treatments",
        treatment = "with albuterol, as prescribed"
    ),
    mobility = Mobility(
        description = "Assisted with turning and deep breathing exercises",
        frequency = "every 2 hours"
    )
)

val treatmentPlanFourthPatient = TreatmentPlan(
    antibiotics = Medication(
        name = "Insulin",
        dosage = "18 units",
        frequency = "Every 3 hours before meals"
    ),
    respiratorySupport = RespiratorySupport(
        method = "N/A",
        treatment = "N/A"
    ),
    mobility = Mobility(
        description = "Great",
        frequency = "N/A"
    )
)

val treatmentPlanHypertension = TreatmentPlan(
    antibiotics = Medication(
        name = "Lisinopril",
        dosage = "20 mg",
        frequency = "Once daily"
    ),
    respiratorySupport = RespiratorySupport(
        method = "N/A",
        treatment = "N/A"
    ),
    mobility = Mobility(
        description = "Normal",
        frequency = "N/A"
    )
)

val treatmentPlanCAD = TreatmentPlan(
    antibiotics = Medication(
        name = "Aspirin",
        dosage = "81 mg",
        frequency = "Once daily"
    ),
    respiratorySupport = RespiratorySupport(
        method = "N/A",
        treatment = "N/A"
    ),
    mobility = Mobility(
        description = "Moderate, advised light activities",
        frequency = "N/A"
    )
)

val treatmentPlanRA = TreatmentPlan(
    antibiotics = Medication(
        name = "Methotrexate",
        dosage = "15 mg",
        frequency = "Once weekly"
    ),
    respiratorySupport = RespiratorySupport(
        method = "N/A",
        treatment = "N/A"
    ),
    mobility = Mobility(
        description = "Limited due to joint pain",
        frequency = "Physiotherapy twice a week"
    )
)

val treatmentPlanTuberculosis = TreatmentPlan(
    antibiotics = Medication(
        name = "Isoniazid",
        dosage = "300 mg",
        frequency = "Once daily"
    ),
    respiratorySupport = RespiratorySupport(
        method = "N/A",
        treatment = "N/A"
    ),
    mobility = Mobility(
        description = "Restricted, advised rest",
        frequency = "N/A"
    )
)

val treatmentPlanFlu = TreatmentPlan(
    antibiotics = Medication(
        name = "Oseltamivir",
        dosage = "75 mg",
        frequency = "Twice daily for 5 days"
    ),
    respiratorySupport = RespiratorySupport(
        method = "N/A",
        treatment = "N/A"
    ),
    mobility = Mobility(
        description = "Restricted, advised rest",
        frequency = "N/A"
    )
)

val treatmentPlanCOPD = TreatmentPlan(
    antibiotics = Medication(
        name = "Albuterol",
        dosage = "2 puffs",
        frequency = "Every 4-6 hours as needed"
    ),
    respiratorySupport = RespiratorySupport(
        method = "Oxygen therapy",
        treatment = "2-4 L/min as required"
    ),
    mobility = Mobility(
        description = "Limited, use of walking aids advised",
        frequency = "Physiotherapy thrice a week"
    )
)

val treatmentPlanOsteoporosis = TreatmentPlan(
    antibiotics = Medication(
        name = "Alendronate",
        dosage = "70 mg",
        frequency = "Once weekly"
    ),
    respiratorySupport = RespiratorySupport(
        method = "N/A",
        treatment = "N/A"
    ),
    mobility = Mobility(
        description = "Moderate, avoid high-impact activities",
        frequency = "Physiotherapy twice a week"
    )
)

val treatmentPlanBackPain = TreatmentPlan(
    antibiotics = Medication(
        name = "Ibuprofen",
        dosage = "400 mg",
        frequency = "Every 6-8 hours as needed"
    ),
    respiratorySupport = RespiratorySupport(
        method = "N/A",
        treatment = "N/A"
    ),
    mobility = Mobility(
        description = "Moderate, avoid strenuous activities",
        frequency = "Physiotherapy thrice a week"
    )
)
