package com.example.newstracker

import android.app.Application
import com.example.newstracker.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf( networkModule, databaseModule, repositoryModule, viewModelModule))
        }
    }
}