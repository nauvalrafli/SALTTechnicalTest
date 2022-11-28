package com.example.salttechnicaltest.data.repository

import android.content.Context
import android.widget.Toast
import com.example.salttechnicaltest.data.api.HomeApi
import com.example.salttechnicaltest.data.model.response.GetUserResponse
import com.example.salttechnicaltest.utils.onSuccessOrError
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

class HomeRepo @Inject constructor(
    private val baseRepo: BaseRepo,
    private val context: Context
) {

    suspend fun getUserList(
        page : Int = 1,
        onComplete : (GetUserResponse) -> Unit = {}
    ) {
        try {
            baseRepo.provideHome().getUserList(page).onSuccessOrError(
                invokeError = {
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                },
                invokeSuccess = onComplete
            )
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

}