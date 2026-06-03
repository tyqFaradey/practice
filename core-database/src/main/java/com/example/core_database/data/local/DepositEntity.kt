package com.example.core_database.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deposits")
data class Deposit(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: Int,
    val initialAmount: Double,
    val months: Int,
    val rate: Double,
    val monthlyTopUp: Double,
    val finalAmount: Double,
    val profit: Double,
    val date: String
)