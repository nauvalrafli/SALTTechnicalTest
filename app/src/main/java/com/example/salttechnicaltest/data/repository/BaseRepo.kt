package com.example.salttechnicaltest.data.repository

import com.example.salttechnicaltest.data.api.AuthApi
import com.example.salttechnicaltest.data.api.HomeApi
import com.example.salttechnicaltest.data.endpoint.ReqresUrl
import dagger.hilt.android.scopes.ActivityScoped
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@ActivityScoped
class BaseRepo {
    private fun retrofitApp() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(ReqresUrl.baseUrl)
            .client(OkHttpClient().newBuilder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideHome(): HomeApi = retrofitApp().create(HomeApi::class.java)
    fun provideAuth(): AuthApi = retrofitApp().create(AuthApi::class.java)

}