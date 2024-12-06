package com.ammar.ishfaq.drugs.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ammar.ishfaq.drugs.models.drugs.Drugs

@Dao
interface DrugDao {
    @Insert
    suspend fun insert(user: Drugs)

    @Query("SELECT * FROM drugs_table")
    suspend fun getAllDrugs(): Drugs?

    @Query("DELETE FROM drugs_table")
    suspend fun clearAllDrugs()
}