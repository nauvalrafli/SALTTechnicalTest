package com.example.salttechnicaltest.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.salttechnicaltest.data.datastore.DataStoreManager
import com.example.salttechnicaltest.data.datastore.dataStore
import com.example.salttechnicaltest.data.datastore.getFirstValue
import com.example.salttechnicaltest.data.datastore.setValue
import com.example.salttechnicaltest.data.repository.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val authRepo: AuthRepo,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    val email = mutableStateOf("")
    val password = mutableStateOf("")

    fun login(
        onSuccess: () -> Unit = {}
    ) {
        viewModelScope.launch {
            authRepo.login(
                username = email.value,
                password = password.value
            ) {
                launch {
                    dataStoreManager.token.setValue(context, it.token)
                }
                onSuccess()
            }
        }
    }

    suspend fun register(
        onSuccess: () -> Unit = {}
    ) {
        viewModelScope.launch {
            authRepo.register(
                username = email.value,
                password = password.value
            ) {
                launch {
                    dataStoreManager.token.setValue(context, it.token)
                }
                onSuccess()
            }
        }
    }

}