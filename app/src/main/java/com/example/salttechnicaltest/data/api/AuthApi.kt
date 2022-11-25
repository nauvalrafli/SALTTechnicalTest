package com.example.salttechnicaltest.data.api

import com.example.salttechnicaltest.data.endpoint.ReqresUrl
import com.example.salttechnicaltest.data.model.request.LoginRequest
import com.example.salttechnicaltest.data.model.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {

    @POST(ReqresUrl.login)
    suspend fun login(@Body body : LoginRequest) : Response<LoginResponse>

}