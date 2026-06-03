package com.example.feature_auth.api

import com.example.core_domain.schemas.Group
import com.example.core_domain.schemas.User
import retrofit2.http.Body
import retrofit2.http.POST

import com.example.feature_auth.api.schemas.LoginRequest
import com.example.feature_auth.api.schemas.RegisterRequest
import com.example.feature_auth.api.schemas.AuthResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface AuthApi {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): AuthResponse

    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest): AuthResponse

    @GET("groups")
    suspend fun getGroups(): List<Group>

    @GET("users/login/{login}")
    suspend fun getUserByLogin(
        @Path("login") login: String
    ): User

}