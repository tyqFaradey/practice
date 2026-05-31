package com.example.core_network.auth

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenManager @Inject constructor(
    @ApplicationContext context: Context
) {
    private val prefs = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)
    companion object {
        private const val KEY_TOKEN = "jwt_token"
    }
    fun saveToken(token: String) { prefs.edit { putString(KEY_TOKEN, token) } }
    fun getToken(): String? { return prefs.getString(KEY_TOKEN, null) }
    fun clearToken() { prefs.edit { remove(KEY_TOKEN) } }
}