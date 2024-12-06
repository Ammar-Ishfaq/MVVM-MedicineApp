package com.ammar.ishfaq.drugs.models.drugs


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AssociatedDrug(
    @SerialName("dose")
    val dose: String,
    @SerialName("name")
    val name: String,
    @SerialName("strength")
    val strength: String
)