package com.example.salttechnicaltest.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.salttechnicaltest.data.repository.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepo: AuthRepo
) : ViewModel() {

    val email = mutableStateOf("")
    val password = mutableStateOf("")

    suspend fun login(
        onSuccess: () -> Unit = {}
    ) {
        authRepo.login(
            email.value,
            password = password.value
        ) {
            onSuccess()
        }
    }

}