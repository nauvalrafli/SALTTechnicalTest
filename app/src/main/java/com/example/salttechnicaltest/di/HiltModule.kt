package com.example.salttechnicaltest.di

import android.content.Context
import com.example.salttechnicaltest.data.datastore.DataStoreManager
import com.example.salttechnicaltest.data.repository.AuthRepo
import com.example.salttechnicaltest.data.repository.BaseRepo
import com.example.salttechnicaltest.data.repository.HomeRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    @Singleton
    fun provideOkHttp() : OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideBaseRepo() : BaseRepo = BaseRepo()

    @Provides
    @Singleton
    fun provideHomeRepo(
        @ApplicationContext context : Context,
        baseRepo: BaseRepo
    ) : HomeRepo = HomeRepo(baseRepo, context)

    @Provides
    @Singleton
    fun provideLoginRepo(
        @ApplicationContext context : Context,
        baseRepo: BaseRepo
    ) = AuthRepo(baseRepo, context)

    @Provides
    @Singleton
    fun provideDataStoreManager(
        @ApplicationContext context: Context
    ) : DataStoreManager = DataStoreManager(context)

}