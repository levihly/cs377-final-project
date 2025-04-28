package com.nau.releasefinder.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nau.releasefinder.data.repository.ReleaseRepository

class ReleaseViewModelFactory(private val repository: ReleaseRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>) : T {
        if (modelClass.isAssignableFrom(ReleaseViewModel::class.java)) {
            return ReleaseViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}