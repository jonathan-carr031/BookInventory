package com.example.bookinventoryapp.book.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfoDto(
    @SerialName("title") val title: String,
    @SerialName("authors") val authors: List<String> = emptyList(),
    @SerialName("publisher") val publisher: String = "",
    @SerialName("publishedDate") val publishedDate: String = "",
    @SerialName("description") val description: String = "",
    @SerialName("industryIdentifiers") val industryIdentifiers: List<IndustryIdentifierDto> = emptyList(),
    @SerialName("pageCount") val pageCount: Int = 0,
    @SerialName("categories") val categories: List<String> = emptyList(),
    @SerialName("averageRating") val averageRating: Int = 0,
    @SerialName("ratingsCount") val ratingsCount: Int = 0,
    @SerialName("maturityRating") val maturityRating: String = "",
    @SerialName("imageLinks") val imageLinks: ImageLinkDto,
    @SerialName("language") val language: String = "",
)