package com.example.bookinventoryapp.book.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResultItemDto(
    @SerialName("kind") val kind: String,
    @SerialName("id") val id: String,
    @SerialName("selfLink") val selfLink: String,
    @SerialName("volumeInfo") val volumeInfo: VolumeInfoDto,
)
