package com.example.bookinventoryapp.book.data.dto

import kotlinx.serialization.SerialName

data class VolumeInfoDto(
    @SerialName("title") val title: String,
    @SerialName("authors") val authors: List<String>,
    @SerialName("publisher") val publisher: String,
    @SerialName("publishedDate") val publishedDate: String,
    @SerialName("description") val description: String,
    @SerialName("industryIdentifiers") val industryIdentifiers: List<IndustryIdentifierDto>,
    @SerialName("pageCount") val pageCount: Int,
    @SerialName("categories") val categories: List<String>,
    @SerialName("averageRating") val averageRating: Int,
    @SerialName("ratingsCount") val ratingsCount: Int,
    @SerialName("maturityRating") val maturityRating: String,
    @SerialName("imageLinks") val imageLinks: ImageLinkDto,
    @SerialName("language") val language: String,
)