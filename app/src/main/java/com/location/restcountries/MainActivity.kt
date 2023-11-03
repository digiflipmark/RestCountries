package com.location.restcountries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import com.location.restcountries.databinding.ActivityMainBinding
import com.location.restcountries.ui.countries.CountriesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val countriesViewModel: CountriesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {

            countriesViewModel.searchNewsFlow.collectLatest {

                Log.e("TAG", "onCreate: ${it.map { it }}" )
            }
        }



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}