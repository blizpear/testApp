package ru.cft.shift2021summer.presentation.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.cft.shift2021summer.domain.model.CountryData
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(app: Application) : AndroidViewModel(app) {

    private val _selectedCountry = MutableLiveData<CountryData>()
    val selectedCountry: LiveData<CountryData>
        get() = _selectedCountry

    fun getArgumentsToVM(data: CountryData){
        _selectedCountry.value = data
    }
}