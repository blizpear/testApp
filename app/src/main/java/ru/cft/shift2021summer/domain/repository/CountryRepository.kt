package ru.cft.shift2021summer.domain.repository

import androidx.lifecycle.LiveData
import ru.cft.shift2021summer.domain.model.CountryData

interface CountryRepository {

    suspend fun refreshCountries()

    fun getCountries(): LiveData<List<CountryData>>
}