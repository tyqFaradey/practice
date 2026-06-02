package com.example.feature_auth.repository


import com.example.core_domain.schemas.Group
import com.example.feature_auth.api.AuthApi
import javax.inject.Inject

class GroupRepository @Inject constructor(
    private val api: AuthApi,
) {
    suspend fun getGroups(): Result<List<Group>> {
        return runCatching {
            api.getGroups()
        }
    }
}