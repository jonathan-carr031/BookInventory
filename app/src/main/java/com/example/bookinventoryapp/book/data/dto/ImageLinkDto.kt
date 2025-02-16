package com.example.bookinventoryapp.book.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageLinkDto(
    @SerialName("smallThumbnail") val smallThumbnail: String,
    @SerialName("thumbnail") val thumbnail: String,
)
