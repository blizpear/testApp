package ru.cft.shift2021summer.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface CountryApiService {
    @GET("all")
    suspend fun getAllCountry(): List<CountryDataNetwork>
}