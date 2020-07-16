package com.example.newstracker.di

import com.example.newstracker.data.repositaries.HomeRepository
import com.example.newstracker.ui.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get<HomeRepository>()) }
}