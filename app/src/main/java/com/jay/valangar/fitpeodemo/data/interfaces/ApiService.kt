package com.jay.valangar.fitpeodemo.data.interfaces


import com.jay.valangar.fitpeodemo.data.model.PhotosModel
import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getPhotos(): List<PhotosModel>
}
