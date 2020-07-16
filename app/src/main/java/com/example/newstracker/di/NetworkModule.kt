package com.example.newstracker.di

import androidx.room.Room
import com.example.newstracker.data.api.ApiService

import com.example.newstracker.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.scope.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule= module {
    factory<OkHttpClient> { okHttpProvider() }
    factory<Retrofit> { retrofitProvider(get()) }
    single { serviceProvvider(get()) }
}
private fun okHttpProvider() :OkHttpClient = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
} else OkHttpClient
.Builder()
.build()

private fun retrofitProvider(okHttpClient: OkHttpClient) :Retrofit = Retrofit.Builder()
.addConverterFactory(MoshiConverterFactory.create())
.baseUrl(BASE_URL)
.client(okHttpClient)
.build()

private fun serviceProvvider (retrofit: Retrofit) : ApiService =
retrofit.create(ApiService::class.java)