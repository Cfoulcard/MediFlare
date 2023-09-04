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

