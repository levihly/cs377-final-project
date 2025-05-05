package com.nau.releasefinder.ui.viewmodel

import android.util.Log
import android.widget.Toast
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

    // function for setting up the nav controller for the view model
    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    // function for fetching the release
    fun fetchRelease(id: String) {
        viewModelScope.launch {
            // try to get release
            try {
                // get the API response
                val response = repository.fetchRelease(id)
                // get the release returned
                val release: Release = response.results.first()
                _title.value = release.title

                // if release is found
                // catalog number will be null if an invalid catalog number was used
                if(release.catno != null) {
                    // go to details w/ the release
                    val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(release)
                    navController.navigate(action)
                }

            // if an error is encountered, return the exception as a log message
            } catch (exception: Exception) {
                // handle error
                Log.d("fetchRelease", exception.toString())
            }
        }
    }
}