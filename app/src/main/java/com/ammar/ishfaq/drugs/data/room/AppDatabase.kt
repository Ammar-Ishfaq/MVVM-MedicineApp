package com.ammar.ishfaq.drugs.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ammar.ishfaq.drugs.models.drugs.Drugs

@Database(entities = [Drugs::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): DrugDao
}
