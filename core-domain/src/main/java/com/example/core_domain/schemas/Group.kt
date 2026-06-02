package com.example.core_domain.schemas

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Group(
    @SerialName("groupId") val id: Int,
    @SerialName("groupName") val name: String
)