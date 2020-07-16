package com.example.newstracker.di

import com.example.newstracker.data.local.SavedDao
import com.example.newstracker.data.repositaries.HomeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { HomeRepository (local = get(),apiService = get()) }
}