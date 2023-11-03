package com.location.restcountries.data.repository

import androidx.paging.PagingData
import com.location.restcountries.data.model.Country
import kotlinx.coroutines.flow.Flow

interface CountriesRepository {

    fun getEuropeanCountries(): Flow<PagingData<Country>>

}