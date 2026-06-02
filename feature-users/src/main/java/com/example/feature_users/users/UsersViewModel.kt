package com.example.feature_users.users

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

import com.example.core_common.BaseViewModel
import com.example.feature_users.repository.UserRepository
import kotlinx.coroutines.launch

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val repository: UserRepository,
) : BaseViewModel<UsersEvent, UsersState>(
        initialState = UsersState()
    ) {
    init {
        onRefresh()
    }

    fun onRefresh() {
        viewModelScope.launch {
            val fetchedUsers = repository.getUsers().getOrNull()!!

            updateState {
                copy(
                    users = fetchedUsers
                )
            }
        }
    }

}