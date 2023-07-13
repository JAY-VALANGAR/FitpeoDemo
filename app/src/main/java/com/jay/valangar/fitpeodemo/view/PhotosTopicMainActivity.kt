package com.jay.valangar.fitpeodemo.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jay.valangar.fitpeodemo.R
import com.jay.valangar.fitpeodemo.data.adapter.PhotoAdapter
import com.jay.valangar.fitpeodemo.databinding.ActivityPhotosTopicMainBinding
import com.jay.valangar.fitpeodemo.viewmodel.TopicPhotosMainViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * The main activity displaying a list of topic photos.
 */
@AndroidEntryPoint
class PhotosTopicMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhotosTopicMainBinding
    private lateinit var photoAdapter: PhotoAdapter
    lateinit var topicPhotosMainViewModel: TopicPhotosMainViewModel
    private lateinit var activity: Activity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_photos_topic_main)
        topicPhotosMainViewModel = ViewModelProvider(this).get(TopicPhotosMainViewModel::class.java)
        activity = this@PhotosTopicMainActivity
        binding.viewModel = topicPhotosMainViewModel
        binding.lifecycleOwner = this
        setupRecyclerView()
        topicPhotosMainViewModel.fetchPhotos()
        observeViewModel()
    }

    /**
     * Sets up the RecyclerView and its adapter.
     */
    private fun setupRecyclerView() {
        photoAdapter = PhotoAdapter(PhotoAdapter.OnClickListener {
                photo ->
            // Create a bundle containing photo details
            val bundle = Bundle()
            bundle.putString("title", photo.title)
            bundle.putString("photoid", photo.id.toString())
            bundle.putString("albumid", photo.albumId.toString())
            bundle.putString("url", photo.url)

            // Start the DetailActivity and pass the bundle as extras
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        })

        // Set up the RecyclerView with the photoAdapter and a LinearLayoutManager
        binding.recyclerView.apply {
            adapter = photoAdapter
            layoutManager = LinearLayoutManager(this@PhotosTopicMainActivity)
        }
    }


    /**
     * Observes the ViewModel's LiveData and updates the adapter's data.
     */
    private fun observeViewModel() {
        topicPhotosMainViewModel.photosLiveData.observe(this) {
            photoAdapter.submitList(it)
            binding.pbProgress.visibility = View.GONE
        }
    }

}

