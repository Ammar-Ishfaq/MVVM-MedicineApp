package com.ammar.ishfaq.drugs.data.hilt

import android.content.Context
import androidx.room.Room
import com.ammar.ishfaq.drugs.data.room.AppDatabase
import com.ammar.ishfaq.drugs.data.room.DrugDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "drug_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): DrugDao {
        return database.userDao()
    }
}
