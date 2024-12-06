package com.ammar.ishfaq.drugs.models.drugs


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Lab(
    @SerialName("missing_field")
    val missingField: String
)