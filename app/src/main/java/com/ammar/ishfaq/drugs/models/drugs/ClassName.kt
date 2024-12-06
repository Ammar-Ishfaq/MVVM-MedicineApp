package com.ammar.ishfaq.drugs.models.drugs


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClassName(
    @SerialName("associatedDrug")
    val associatedDrug: List<AssociatedDrug>,
    @SerialName("associatedDrug#2")
    val associatedDrug2: List<AssociatedDrug>
)