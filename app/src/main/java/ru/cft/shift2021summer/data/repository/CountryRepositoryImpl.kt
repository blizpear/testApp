package ru.cft.shift2021summer.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.cft.shift2021summer.data.database.CountryDatabase
import ru.cft.shift2021summer.domain.model.CountryData
import ru.cft.shift2021summer.data.mapper.dbAsDomainModel
import ru.cft.shift2021summer.data.mapper.netAsDatabaseModel
import ru.cft.shift2021summer.data.network.CountryApiService
import ru.cft.shift2021summer.domain.repository.CountryRepository
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val countryDatabase: CountryDatabase,
    private val countryDataNetwork: CountryApiService
) : CountryRepository {

    override fun getCountries(): LiveData<List<CountryData>> {

        return Transformations.map(countryDatabase.countryDao().getCountries()) {
            it.dbAsDomainModel()
        }
    }


    override suspend fun refreshCountries() {

        withContext(Dispatchers.IO) {
            Log.i("TESTS", "refresh is called")
            val listCountry = countryDataNetwork.getAllCountry()
            countryDatabase.countryDao().insertAll(listCountry.netAsDatabaseModel())
        }
    }
}