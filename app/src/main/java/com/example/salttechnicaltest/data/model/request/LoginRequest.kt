package com.example.salttechnicaltest.data.model.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginRequest(
    val email : String,
    val password : String
): Parcelable
