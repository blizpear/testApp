package ru.cft.shift2021summer.domain.usecase

import androidx.lifecycle.LiveData
import ru.cft.shift2021summer.domain.model.CountryData
import ru.cft.shift2021summer.domain.repository.CountryRepository
import javax.inject.Inject

class GetCountryUseCase @Inject constructor(private val countryRepository: CountryRepository) {

    fun execute(): LiveData<List<CountryData>> {
        return countryRepository.getCountries()
    }
}