package com.jay.valangar.fitpeodemo.HiltAndroidApp

import android.app.Application
import com.squareup.picasso.Picasso
import dagger.hilt.android.HiltAndroidApp

/**
 * The custom Application class for the FitPeoDemo application.
 * Annotated with @HiltAndroidApp to enable Hilt dependency injection.
 * Initializes the Picasso library as a singleton instance in the onCreate() method.
 */
@HiltAndroidApp
class TopicApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize Picasso library as a singleton instance
        Picasso.setSingletonInstance(Picasso.Builder(this).build())
    }
}