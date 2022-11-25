package com.example.salttechnicaltest.data.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.salttechnicaltest.data.api.AuthApi
import com.example.salttechnicaltest.data.model.request.LoginRequest
import com.example.salttechnicaltest.data.model.response.LoginResponse
import com.example.salttechnicaltest.utils.onSuccessOrError
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

class AuthRepo @Inject constructor(
    private val baseRepo: BaseRepo,
    private val context: Context
) {

    suspend fun login(
        username: String,
        password: String,
        onSuccess: (LoginResponse) -> Unit = {}
    ) {
        try {
            Log.d("CALLED", username + password)
            baseRepo.provideAuth().login(LoginRequest(username, password)).onSuccessOrError(
                invokeSuccess = onSuccess,
                invokeError = {
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                }
            )
        } catch (e : java.lang.Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

}