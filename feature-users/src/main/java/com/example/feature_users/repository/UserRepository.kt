package com.example.feature_users.repository

import javax.inject.Inject

import com.example.feature_users.api.UsersApi
import com.example.core_domain.schemas.User

class UserRepository @Inject constructor(
    private val api: UsersApi,
) {
    suspend fun getUsers(): Result<List<User>> {
        return runCatching {
            api.getUsers()
        }
    }
}