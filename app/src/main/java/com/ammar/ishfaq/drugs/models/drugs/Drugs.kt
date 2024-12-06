package com.ammar.ishfaq.drugs.models.drugs


import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "drugs_table")
@Serializable
data class Drugs(
    @PrimaryKey(autoGenerate = true) val id: Int? = 0,

    @SerialName("problems")
    val problems: List<Problem>
)