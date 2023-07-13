package com.jay.valangar.fitpeodemo.data.model

import java.io.Serializable


/**
 * Represents a photo related to a topic.
 *
 * @param albumId The ID of the album to which the photo belongs.
 * @param id The unique ID of the photo.
 * @param title The title or caption of the photo.
 * @param url The URL of the photo.
 * @param thumbnailUrl The URL of the thumbnail image for the photo.
 */
data class TopicPhoto(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String,

    ) : Serializable