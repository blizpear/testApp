package ru.cft.shift2021summer.data.network

import retrofit2.http.GET

interface CountryApiService {
    @GET("all")
    suspend fun getAllCountry(): List<CountryDataNetwork>
}