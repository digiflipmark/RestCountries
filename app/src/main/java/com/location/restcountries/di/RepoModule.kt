package com.location.restcountries.di

import com.location.restcountries.data.remote.CountryApi
import com.location.restcountries.data.repository.CountriesRepository
import com.location.restcountries.data.repository.CountriesRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Provides
    @Singleton
    fun provideRepo(countryApi: CountryApi): CountriesRepository {
        return CountriesRepositoryImp(countryApi)
    }
}