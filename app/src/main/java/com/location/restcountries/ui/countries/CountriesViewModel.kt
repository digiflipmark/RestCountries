package com.location.restcountries.ui.countries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.location.restcountries.data.repository.CountriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(countriesRepository: CountriesRepository) :
    ViewModel() {

    val searchNewsFlow = countriesRepository.getEuropeanCountries().map { pagingData ->
        pagingData.map { it }
    }.cachedIn(viewModelScope)
}