package com.location.restcountries.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.location.restcountries.data.model.Country
import com.location.restcountries.data.remote.CountryApi
import okio.IOException
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject

private const val STARTING_PAGE_INDEX = 0
const val NETWORK_PAGE_SIZE = 10

class CountriesPagingSource @Inject constructor(private val countryApi: CountryApi) :
    PagingSource<Int, Country>() {

    override fun getRefreshKey(state: PagingState<Int, Country>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Country> {

        val pageIndexedKey = params.key ?: 1

        return try {
            val response = countryApi.getEuropeanCountries()
            LoadResult.Page(data = response, prevKey = null, nextKey = null)
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        } catch (exception: UnknownHostException) {
            LoadResult.Error(exception)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}