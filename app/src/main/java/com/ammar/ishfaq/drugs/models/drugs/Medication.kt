package com.ammar.ishfaq.drugs.models.drugs


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Medication(
    @SerialName("medicationsClasses")
    val medicationsClasses: List<MedicationsClasse>
)