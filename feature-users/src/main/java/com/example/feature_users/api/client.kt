package com.example.feature_users.api

import retrofit2.http.GET

import com.example.core_domain.schemas.User


interface UsersApi {
    @GET("/users")
    suspend fun getUsers(): List<User>
}