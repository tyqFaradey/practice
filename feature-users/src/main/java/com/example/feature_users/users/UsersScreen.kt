package com.example.feature_users.users

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.core_ui.BaseScreen
import com.example.core_ui.ButtonsPanel
import com.example.core_ui.Link
import com.example.core_ui.PADDING
import com.example.core_ui.TextField
import com.example.feature_users.ui.UserCard

@Composable
fun UsersScreen(
    state: UsersState,
    onRefresh: () -> Unit,
) {
    BaseScreen(
        title = "Пользователи",
        bottomBar = {
            Column(
                modifier = Modifier
                    .imePadding()
                    .padding(PADDING),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(PADDING)
            ) {
                ButtonsPanel {
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = onRefresh
                    ) {
                        Text("Обновить")
                    }
                }
            }
        }
    ) {
        state.users.forEach { user ->
            UserCard(user)
        }
    }
}