package ci.nsu.mobile.main.model.dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class PersonDto(
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val birthDay: Date,
    val gender: String,
    val groupId: Int,
)