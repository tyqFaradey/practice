package com.example.core_database.data.repository

import kotlinx.coroutines.flow.Flow

import javax.inject.Inject
import javax.inject.Singleton

import com.example.core_database.data.local.DepositDao
import com.example.core_database.data.local.Deposit

@Singleton
class DepositRepository @Inject constructor(
    private val dao: DepositDao
) {
    suspend fun insert(calculation: Deposit) {
        dao.insert(calculation)
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }

    fun getAll(): Flow<List<Deposit>> {
        return dao.getAll()
    }

    fun getDepositsByUserId(userId: Int): Flow<List<Deposit>> {
        return dao.getDepositsByUserId(userId)
    }

     suspend fun deleteDepositsByUserId(userId: Int) {
        return dao.deleteDepositsByUserId(userId)
    }
}