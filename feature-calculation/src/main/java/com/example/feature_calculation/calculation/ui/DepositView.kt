package com.example.feature_calculation.calculation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core_database.data.local.Deposit
@Composable
fun DepositView(deposit: Deposit, modifier: Modifier = Modifier) {
    Column {
        Text("ID: ${deposit.id}")
        Text("ID: ${deposit.userId}")
        Text("Начальный взнос: ${"%.1f".format(deposit.initialAmount)}")
        Text("Срок: ${deposit.months} мес.")
        Text("Ставка: ${deposit.rate}%")
        Text("Пополнение: ${"%.1f".format(deposit.monthlyTopUp)}")
        Text("Итог: ${"%.1f".format(deposit.finalAmount)}")
        Text("Прибыль: ${"%.1f".format(deposit.profit)}")
        Text("Дата: ${deposit.date}")
    }
}