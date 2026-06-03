package com.example.core_session
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import androidx.core.content.edit

@Singleton
class SessionRepository @Inject constructor(
    @ApplicationContext context: Context
) {

    private val sharedPreferences = context.getSharedPreferences(
        "session_prefs",
        Context.MODE_PRIVATE
    )

    private companion object {
        const val KEY_TOKEN = "auth_token"
        const val KEY_USER_ID = "user_id"
    }

     fun saveToken(token: String) {
        sharedPreferences.edit { putString(KEY_TOKEN, token) }
    }

    fun saveUserId(id: String) {
        sharedPreferences.edit { putString(KEY_USER_ID, id) }
    }

     fun getUserId(): String? {
        return sharedPreferences.getString(KEY_USER_ID, null)
    }

    fun getToken(): String? {
        return sharedPreferences.getString(KEY_TOKEN, null)
    }

     fun clearSession() {
        sharedPreferences.edit { clear() }
    }
}