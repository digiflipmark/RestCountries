package com.location.restcountries.data.remote

import com.location.restcountries.data.model.Country
import retrofit2.http.GET

interface CountryApi {

    @GET("region/europe")
    suspend fun getEuropeanCountries(): List<Country>
}