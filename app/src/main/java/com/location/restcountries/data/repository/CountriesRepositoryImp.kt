package com.location.restcountries.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.location.restcountries.data.model.Country
import com.location.restcountries.data.remote.CountryApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CountriesRepositoryImp @Inject constructor(private val countryApi: CountryApi) : CountriesRepository {

    override fun getEuropeanCountries(): Flow<PagingData<Country>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false,
                initialLoadSize = 10,
                prefetchDistance = 5
            ), pagingSourceFactory = { CountriesPagingSource(countryApi) }
        ).flow
    }


}