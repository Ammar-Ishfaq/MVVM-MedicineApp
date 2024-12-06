package com.ammar.ishfaq.drugs.models.drugs


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Diabete(
    @SerialName("labs")
    val labs: List<Lab>,
    @SerialName("medications")
    val medications: List<Medication>
)