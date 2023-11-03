package com.location.restcountries.ui.countries

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.location.restcountries.R
import com.location.restcountries.data.repository.CountriesRepository
import com.location.restcountries.data.repository.CountriesRepositoryImp
import com.location.restcountries.databinding.FragmentCountriesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CountriesFragment : Fragment(R.layout.fragment_countries) {

    private var _binding: FragmentCountriesBinding? = null
    private val binding get() = _binding!!



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCountriesBinding.bind(view)




    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}