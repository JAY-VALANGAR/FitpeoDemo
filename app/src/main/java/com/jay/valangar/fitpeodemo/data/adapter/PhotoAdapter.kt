package com.jay.valangar.fitpeodemo.data.adapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jay.valangar.fitpeodemo.R
import com.jay.valangar.fitpeodemo.data.model.TopicPhoto
import com.jay.valangar.fitpeodemo.databinding.ItemMainPhotoTopicCardBinding
import com.squareup.picasso.Picasso

/**
 * RecyclerView adapter for displaying a list of TopicPhoto items.
 *
 * @param onClickListener The click listener for handling item clicks.
 */
class PhotoAdapter (private val onClickListener: OnClickListener) : ListAdapter<TopicPhoto, PhotoAdapter.PhotoViewHolder>(PhotoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        // Inflate the item layout for each view holder
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMainPhotoTopicCardBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(photo)
        }
        holder.bind(photo)
    }

    /**
     * ViewHolder class for binding and displaying individual TopicPhoto items.
     *
     * @param binding The generated view binding for the item layout.
     */
    inner class PhotoViewHolder(private val binding: ItemMainPhotoTopicCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        /**
         * Binds the TopicPhoto data to the view holder.
         *
         * @param photo The TopicPhoto object to bind.
         */
        fun bind(photo: TopicPhoto) {
            binding.photo = photo

            // Use Picasso library to load the thumbnail image into the ImageView
            Picasso.get()
                .load(photo.thumbnailUrl)
                .placeholder(ColorDrawable(Color.LTGRAY))
                .error(R.drawable.ic_launcher_background)
                .into(binding.photoImageView)

            // Execute any pending bindings to update the UI
            binding.executePendingBindings()
        }
    }

    /**
     * Click listener interface for handling item clicks in the adapter.
     *
     * @param clickListener The lambda function to handle item clicks.
     */
    class OnClickListener (val clickListener: (photo: TopicPhoto) -> Unit) {
        fun onClick(photo: TopicPhoto) = clickListener(photo)
    }
}


/**
 * DiffUtil callback for comparing TopicPhoto items in the RecyclerView adapter.
 */
class PhotoDiffCallback : DiffUtil.ItemCallback<TopicPhoto>() {
    override fun areItemsTheSame(oldItem: TopicPhoto, newItem: TopicPhoto): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TopicPhoto, newItem: TopicPhoto): Boolean {
        return oldItem == newItem
    }
}
