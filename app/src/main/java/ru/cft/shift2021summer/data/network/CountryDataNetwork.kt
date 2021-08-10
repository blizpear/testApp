package ru.cft.shift2021summer.data.network

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryDataNetwork(
    val name: String,
    val capital: String,
    val region: String,
    val flag: String,
    //val topLevelDomain: List<String>,
    val population: String,
    val area: Double?,
    //val languages: List<Map<String, String>>
)
