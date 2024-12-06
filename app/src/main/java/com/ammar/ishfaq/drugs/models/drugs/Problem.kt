package com.ammar.ishfaq.drugs.models.drugs


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Problem(
    @SerialName("Asthma")
    val asthma: List<Asthma>,
    @SerialName("Diabetes")
    val diabetes: List<Diabete>
)