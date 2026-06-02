package com.example.feature_auth.register

import com.example.core_common.UiState
import com.example.core_domain.Gender
import com.example.core_domain.schemas.Group
import com.example.core_domain.schemas.Person
import com.example.core_utils.DateMapper
import com.example.feature_auth.api.schemas.RegisterRequest

data class RegisterState(
    val firstName: String = "",
    val lastName: String = "",
    val middleName: String = "",
    val birthDate: String = "",
    val gender: Gender? = null,
    val group: Group? = null,

    val login: String = "",
    val email: String = "",
    val phone: String = "",
    val password: String = "",

    val isLoading: Boolean = false,
    val groups: List<Group> = emptyList(),

    val firstNameErrors: List<String> = emptyList(),
    val lastNameErrors: List<String> = emptyList(),
    val middleNameErrors: List<String> = emptyList(),
    val birthDateErrors: List<String> = emptyList(),
    val genderErrors: List<String> = emptyList(),
    val groupErrors: List<String> = emptyList(),

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

        birthDate = DateMapper.mapUiDateToApi(birthDate),
        gender = "MALE",
        groupId = 1
    )
    return RegisterRequest(
        login = login,
        email = email,
        phoneNumber = phone,
        password = password,

        person = person
    )
}