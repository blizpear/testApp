package ru.cft.shift2021summer.domain.usecase

import ru.cft.shift2021summer.domain.repository.CountryRepository
import javax.inject.Inject

class RefreshCountryUseCase@Inject constructor(private val countryRepository: CountryRepository) {

    suspend fun execute(){
        countryRepository.refreshCountries()
    }
}