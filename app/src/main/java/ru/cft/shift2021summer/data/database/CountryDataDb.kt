package ru.cft.shift2021summer.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CountryDataDb constructor(
    @PrimaryKey(autoGenerate = false)
    val name: String,
    val capital: String,
    val region: String,
    val flag: String,
   // val topLevelDomain: List<String>,
    val population: String,
    val area: Double?,
   // val languages: List<Map<String, String>>
)