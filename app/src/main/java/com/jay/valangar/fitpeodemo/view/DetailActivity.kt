package com.jay.valangar.fitpeodemo.view

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jay.valangar.fitpeodemo.R
import com.jay.valangar.fitpeodemo.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

/**
 * Activity for displaying detailed information about a photo.
 */

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        // Retrieve the data passed from the previous activity
        val bundle = intent.extras

        if (bundle != null){

            // Set the photo ID, album ID, and title in the corresponding views
            val photoId = bundle.getString("photoid")
            val albumId = bundle.getString("albumid")
            val title = bundle.getString("title")

            if (photoId != null) {
                binding.photoId.text = "${getString(R.string.photo_id)}$photoId"
            }

            if (albumId != null) {
                binding.photoAlbumId.text = "${getString(R.string.album_id)}$albumId"
            }

            if (title != null) {
                binding.titleTextView.text = title
            }

            // Load and display the photo image using Picasso library
            Picasso.get()
                .load("${bundle.getString("url")}")
                .placeholder(ColorDrawable(Color.LTGRAY))
                .error(R.drawable.ic_launcher_background)
                .into(binding.headerImageView)
        }
    }

}