package com.example.feature_users.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core_domain.schemas.User


@Composable
fun UserCard(user: User, modifier: Modifier = Modifier) {
    Card {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text("ID: ${user.id}")
            Text("Логин: ${user.login}")
            Text("Почта: ${user.email} мес.")
            Text("Телефон: ${user.phoneNumber}%")
        }
    }
}