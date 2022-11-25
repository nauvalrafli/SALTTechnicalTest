package com.example.salttechnicaltest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SaltTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}