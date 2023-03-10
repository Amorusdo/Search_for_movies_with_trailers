package com.example.movirapp.presentation

import android.app.Application
import com.example.movirapp.di.dataModule
import com.example.movirapp.di.domainModule
import com.example.movirapp.di.presentation
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(dataModule, domainModule, presentation))
        }
    }
}