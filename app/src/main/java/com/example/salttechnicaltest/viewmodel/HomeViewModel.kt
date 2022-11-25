package com.example.salttechnicaltest.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.salttechnicaltest.data.model.local.User
import com.example.salttechnicaltest.data.repository.HomeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepo: HomeRepo
) : ViewModel() {

    val userList = mutableStateListOf<User>()

    suspend fun getUserList(
        onSuccess: () -> Unit = {}
    ) {
        homeRepo.getUserList {
            userList.addAll(it.data)
            onSuccess()
        }
    }

}