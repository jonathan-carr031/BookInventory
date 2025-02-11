package com.example.bookinventoryapp.book.data.dto

import kotlinx.serialization.SerialName

data class SearchResultItemDto(
    @SerialName("kind") val kind: String,
    @SerialName("id") val id: String,
    @SerialName("selfLink") val selfLink: String,
    @SerialName("volumeInfo") val volumeInfo: VolumeInfoDto,
)
