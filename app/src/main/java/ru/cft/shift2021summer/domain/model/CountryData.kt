package ru.cft.shift2021summer.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CountryData(
    val name: String,
    val capital: String,
    val region: String,
    val flag: String,
   // val topLevelDomain: List<String>,
    val population: String,
    val area: Double?,
    //val languages: List<Map<String, String>>
) : Parcelable
