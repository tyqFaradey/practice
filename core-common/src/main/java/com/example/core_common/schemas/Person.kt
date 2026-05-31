package com.example.core_common.schemas

import kotlinx.serialization.Serializable
@Serializable
data class Person(
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val birthDate: String,
    val gender: String,
    val groupId: Int,
)