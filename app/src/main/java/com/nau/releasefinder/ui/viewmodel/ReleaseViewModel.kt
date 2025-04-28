package com.nau.releasefinder.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nau.releasefinder.data.repository.ReleaseRepository
import kotlinx.coroutines.launch

class ReleaseViewModel(private val repository: ReleaseRepository) : ViewModel() {
    private val _title = MutableLiveData<String>()
    val title: LiveData<String> get() = _title

    fun fetchRelease(id: String) {
        viewModelScope.launch {
            try {
                val response = repository.fetchRelease(id)
                _title.value = response.title
            } catch (exception: Exception) {
                // handle error
            }
        }
    }
}