package com.example.newstracker.data.repositaries


import com.example.newstracker.data.api.ApiService
import com.example.newstracker.data.local.AppDataBase
import com.example.newstracker.data.local.SavedDao


import com.example.newstracker.utils.Constants.Companion.API_KEY
import com.example.newstracker.utils.Constants.Companion.LANGUAGE
import com.example.newstracker.utils.Constants.Companion.SEARCH_KEYWORD
import kotlinx.coroutines.flow.flow
import org.koin.core.KoinComponent
import org.koin.core.inject

data class HomeRepository(val local :AppDataBase,val apiService: ApiService) {

    suspend fun getAllNews() = local.savedDoa().getAllSavedNews()
    //flow {emit(server.getEverythingNews(API_KEY, LANGUAGE, SEARCH_KEYWORD))}
}