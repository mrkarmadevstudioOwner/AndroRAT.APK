package com.lunex

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LunexApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize app-wide components here
    }
}
