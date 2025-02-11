package com.example.bookinventoryapp.book.data.dto

import kotlinx.serialization.SerialName

data class ImageLinkDto(
    @SerialName("smallThumbnail") val smallThumbnail: String,
    @SerialName("thumbnail") val thumbnail: String,
)
