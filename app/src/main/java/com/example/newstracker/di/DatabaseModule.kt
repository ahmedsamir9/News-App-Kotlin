package com.example.newstracker.di

import android.content.Context
import androidx.room.Room
import com.example.newstracker.data.local.AppDataBase

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single { databaseInstanceProvider(get()) }
    single { get<AppDataBase>().savedDoa() }
    single { get<AppDataBase>().favoriteDao() }
}
private fun databaseInstanceProvider(ctx:Context):AppDataBase = Room
    .databaseBuilder(ctx, AppDataBase::class.java,"newsDB").build()