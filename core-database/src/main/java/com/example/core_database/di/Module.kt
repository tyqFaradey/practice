package com.example.core_database.di

import android.content.Context
import androidx.room.Room
import com.example.core_database.data.local.AppDatabase
import com.example.core_database.data.local.DepositDao
import com.example.core_database.data.repository.DepositRepository
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
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(db: AppDatabase): DepositDao {
        return db.dao()
    }

    @Provides
    @Singleton
    fun provideRepository(
        dao: DepositDao
    ): DepositRepository {
        return DepositRepository(dao)
    }
}