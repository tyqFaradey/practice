package ci.nsu.mobile.main.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val login: String,
    val password: String,
    val email: String,
    val phoneNumber: String,
    val personId: Int,
    val roleId: Int = 1,
    val authAllowed: Boolean = true,
)