package com.example.newstracker.data.api

import com.example.newstracker.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("everything")
    public suspend fun getEverythingNews(@Query("apiKey")apiKey: String, @Query("language")language:String
                                         , @Query("q")about:String): Response<NewsResponse>
    @GET("top-headlines")
    suspend fun getHeadLinesNews(@Query("apiKey")apiKey: String, @Query("country")country:String
                                 , @Query("category")about:String): Response<NewsResponse>
}