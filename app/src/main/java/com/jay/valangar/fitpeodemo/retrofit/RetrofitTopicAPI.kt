package com.jay.valangar.fitpeodemo.retrofit

import retrofit2.Response
import retrofit2.http.GET
import com.jay.valangar.fitpeodemo.data.model.TopicPhoto


/**
 * Retrofit API interface for retrieving topic photos.
 */
interface RetrofitTopicAPI {

    /**
     * Retrieves a list of topic photos.
     *
     * @return A Response object containing the list of topic photos.
     */
    @GET("photos")
    suspend fun getPhotos() : Response<List<TopicPhoto>>

}