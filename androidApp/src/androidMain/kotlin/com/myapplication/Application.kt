package com.myapplication

import android.app.Application
import di.androidModule
import di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(androidModule, viewModelModule)
        }
    }
}