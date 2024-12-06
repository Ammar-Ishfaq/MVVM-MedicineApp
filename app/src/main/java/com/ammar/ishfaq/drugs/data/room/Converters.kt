package com.ammar.ishfaq.drugs.data.room

import androidx.room.TypeConverter
import com.ammar.ishfaq.drugs.models.drugs.AssociatedDrug
import com.ammar.ishfaq.drugs.models.drugs.Asthma
import com.ammar.ishfaq.drugs.models.drugs.ClassName
import com.ammar.ishfaq.drugs.models.drugs.Lab
import com.ammar.ishfaq.drugs.models.drugs.Medication
import com.ammar.ishfaq.drugs.models.drugs.MedicationsClasse
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import com.ammar.ishfaq.drugs.models.drugs.Problem

class Converters {

    @TypeConverter
    fun fromProblemList(value: List<Problem>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toProblemList(value: String): List<Problem> {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromAssociatedDrugList(value: List<AssociatedDrug>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toAssociatedDrugList(value: String): List<AssociatedDrug> {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun fromLabList(value: List<Lab>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toLabList(value: String): List<Lab> {
        return Json.decodeFromString(value)
    }
    @TypeConverter
    fun fromMedicationList(value: List<Medication>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toMedicationList(value: String): List<Medication> {
        return Json.decodeFromString(value)
    }
    @TypeConverter
    fun fromMedicationsClasseList(value: List<MedicationsClasse>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toMedicationsClasseList(value: String): List<MedicationsClasse> {
        return Json.decodeFromString(value)
    }
    @TypeConverter
    fun fromClassNameList(value: List<ClassName>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toClassNameList(value: String): List<ClassName> {
        return Json.decodeFromString(value)
    }
    @TypeConverter
    fun fromAsthmaList(value: List<Asthma>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toAsthmaList(value: String): List<Asthma> {
        return Json.decodeFromString(value)
    }
}
