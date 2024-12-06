package com.ammar.ishfaq.drugs.models.drugs


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MedicationsClasse(
    @SerialName("className")
    val className: List<ClassName>,
    @SerialName("className2")
    val className2: List<ClassName>
)