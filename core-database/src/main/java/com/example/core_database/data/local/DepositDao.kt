package com.example.core_database.data.local

import kotlinx.coroutines.flow.Flow

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DepositDao {
    @Query("SELECT * FROM deposits ORDER BY id DESC")
    fun getAll(): Flow<List<Deposit>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(calculation: Deposit)

    @Query("DELETE FROM deposits")
    suspend fun deleteAll()

    @Query("SELECT * FROM deposits WHERE userId = :userId")
    fun getDepositsByUserId(userId: Int): Flow<List<Deposit>>

    @Query("DELETE FROM deposits WHERE userId = :userId")
    suspend fun deleteDepositsByUserId(userId: Int)
}