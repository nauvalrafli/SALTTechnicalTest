package com.example.salttechnicaltest.data.api

import com.example.salttechnicaltest.data.endpoint.ReqresUrl
import com.example.salttechnicaltest.data.model.request.LoginRequest
import com.example.salttechnicaltest.data.model.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST(ReqresUrl.Auth.login)
    suspend fun login(@Body body : LoginRequest) : Response<LoginResponse>

    @POST(ReqresUrl.Auth.register)
    suspend fun register(@Body body : LoginRequest) : Response<LoginResponse>

}