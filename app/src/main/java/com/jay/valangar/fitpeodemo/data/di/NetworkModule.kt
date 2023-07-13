package com.jay.valangar.fitpeodemo.data.di

import com.jay.valangar.fitpeodemo.retrofit.RetrofitTopicAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Dagger module that provides dependencies related to network operations.
 * This module is installed in the SingletonComponent to provide singleton instances.
 */
@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    private val BASE_URL = "https://jsonplaceholder.typicode.com"

    /**
     * Provides a singleton instance of the Retrofit client.
     *
     * @return The Retrofit instance.
     */
    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * Provides a singleton instance of the RetrofitTopicAPI.
     * Injects the Retrofit client into the API interface.
     *
     * @param retrofit The Retrofit instance to use.
     * @return The RetrofitTopicAPI instance.
     */
    @Singleton
    @Provides
    fun providesFakerAPI(retrofit: Retrofit) : RetrofitTopicAPI {
        return retrofit.create(RetrofitTopicAPI::class.java)
    }
}