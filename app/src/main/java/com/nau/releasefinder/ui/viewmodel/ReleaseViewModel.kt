package com.nau.releasefinder.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.nau.releasefinder.data.database.model.Release
import com.nau.releasefinder.data.repository.ReleaseRepository
import com.nau.releasefinder.ui.HomeFragmentDirections
import kotlinx.coroutines.launch

class ReleaseViewModel(private val repository: ReleaseRepository) : ViewModel() {
    private val _title = MutableLiveData<String>()
    private lateinit var navController: NavController
    val title: LiveData<String> get() = _title

    fun fetchRelease(id: String) {
        viewModelScope.launch {
            try {
                // get the API response
                val response = repository.fetchRelease(id)
                // get the release returned
                val release: Release = response.results.first()
                println(release.title)
                _title.value = release.title

                // go to details w/ the release
                val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(release)
                navController.navigate(action)

            } catch (exception: Exception) {
                // handle error
                Log.d("fetchRelease", exception.toString())
            }
        }
    }
}