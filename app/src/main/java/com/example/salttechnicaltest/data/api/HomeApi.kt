package com.example.salttechnicaltest.data.api

import com.example.salttechnicaltest.data.endpoint.ReqresUrl
import com.example.salttechnicaltest.data.model.response.GetUserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApi {

    @GET(ReqresUrl.Users.userList)
    suspend fun getUserList(@Query("page") page : Int) : Response<GetUserResponse>

}