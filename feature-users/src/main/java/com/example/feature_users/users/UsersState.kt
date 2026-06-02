package com.example.feature_users.users

import com.example.core_common.UiState
import com.example.core_domain.schemas.User

data class UsersState(
    val users: List<User> = emptyList(),
    val isLoading: Boolean = false
) : UiState