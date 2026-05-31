package com.example.feature_auth.register

import com.example.core_common.UiState
import com.example.feature_auth.api.schemas.Person
import com.example.feature_auth.api.schemas.LoginRequest
import com.example.feature_auth.api.schemas.RegisterRequest
import com.example.feature_auth.login.LoginState
import kotlinx.serialization.InternalSerializationApi

data class RegisterState(
    val firstName: String = "",
    val lastName: String = "",
    val middleName: String = "",
    val birthDate: String = "",

    val login: String = "",
    val email: String = "",
    val phone: String = "",
    val password: String = "",

    val isLoading: Boolean = false,

    val firstNameErrors: List<String> = emptyList(),
    val lastNameErrors: List<String> = emptyList(),
    val middleNameErrors: List<String> = emptyList(),
    val birthDateErrors: List<String> = emptyList(),

    val loginErrors: List<String> = emptyList(),
    val emailErrors: List<String> = emptyList(),
    val phoneErrors: List<String> = emptyList(),
    val passwordErrors: List<String> = emptyList(),
) : UiState


fun RegisterState.toRegisterRequest(): RegisterRequest {
    val person = Person(
        firstName = firstName,
        lastName = lastName,
        middleName = middleName,

        //TODO сделать для этого интерфейс и обработку
        birthDate = "2007-07-21",
        gender = "MALE",
        groupId = 1
    )
    return RegisterRequest(
        username = login,
        email = email,
        phoneNumber = phone,
        password = password,

        person = person
    )
}