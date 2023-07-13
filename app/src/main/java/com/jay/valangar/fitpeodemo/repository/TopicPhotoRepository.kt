package com.jay.valangar.fitpeodemo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jay.valangar.fitpeodemo.data.model.TopicPhoto
import com.jay.valangar.fitpeodemo.retrofit.RetrofitTopicAPI
import javax.inject.Inject

/**
 * Repository class for managing topic photos.
 *
 * @param retrofitTopicAPI The RetrofitTopicAPI instance for making API requests.
 */
class TopicPhotoRepository @Inject constructor(private val retrofitTopicAPI: RetrofitTopicAPI) {

    /**
     * LiveData object that holds the list of topic photos.
     */
    private val _photos = MutableLiveData<List<TopicPhoto>>()
    val photos : LiveData<List<TopicPhoto>>
        get() = _photos

    /**
     * Retrieves the list of topic photos.
     *
     * @return The list of topic photos.
     */
    suspend fun getPhotos(): List<TopicPhoto>{
        val result = retrofitTopicAPI.getPhotos()
        if(result.isSuccessful && result.body() != null){
            _photos.postValue(result.body())
        }
        return result.body()!!
    }

}