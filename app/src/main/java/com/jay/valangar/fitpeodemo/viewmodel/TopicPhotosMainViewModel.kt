package com.jay.valangar.fitpeodemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jay.valangar.fitpeodemo.data.model.TopicPhoto
import com.jay.valangar.fitpeodemo.repository.TopicPhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel class for the main activity displaying topic photos.
 */
@HiltViewModel
class TopicPhotosMainViewModel @Inject constructor(private val repository: TopicPhotoRepository) : ViewModel() {
    /**
     * LiveData representing the list of topic photos.
     */
    val photosLiveData : LiveData<List<TopicPhoto>> get() = repository.photos
    private val _photos = MutableLiveData<List<TopicPhoto>>()



    /**
     * Fetches the list of topic photos from the repository.
     */
    fun fetchPhotos() {
        viewModelScope.launch {
            try {
                _photos.value = repository.getPhotos()
            } catch (e: Exception) {
                e.message
            }
        }
    }

}