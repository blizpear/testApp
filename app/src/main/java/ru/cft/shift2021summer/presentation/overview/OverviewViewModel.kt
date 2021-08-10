package ru.cft.shift2021summer.presentation.overview

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.cft.shift2021summer.domain.model.CountryData
import ru.cft.shift2021summer.domain.usecase.GetCountryUseCase
import ru.cft.shift2021summer.domain.usecase.RefreshCountryUseCase
import java.io.IOException
import javax.inject.Inject

//enum class CountryApiStatus { LOADING, ERROR, DONE }


@HiltViewModel
class OverviewViewModel @Inject constructor(
    application: Application,
    private val getCountryUseCase: GetCountryUseCase,
    private val refreshCountryUseCase: RefreshCountryUseCase
) : AndroidViewModel(application) {

    private val _navigateToSelectedCountry = MutableLiveData<CountryData?>()
    val navigateToSelectedCountry: LiveData<CountryData?>
        get() = _navigateToSelectedCountry

    val listCountries: LiveData<List<CountryData>> = getCountryUseCase.execute()

    init {
        viewModelScope.launch {

            try {
                refreshCountryUseCase.execute()
            } catch (networkError: IOException) {
                networkError.message?.let { Log.i("TESTS", it) }
                if (listCountries.value.isNullOrEmpty()) {
                    Log.i("TESTS", "list empty")
                }
            }
        }
    }

    fun displayCountryDetails(countryData: CountryData) {
        _navigateToSelectedCountry.value = countryData
    }

    fun displayCountryDetailsComplete() {
        _navigateToSelectedCountry.value = null
    }
}