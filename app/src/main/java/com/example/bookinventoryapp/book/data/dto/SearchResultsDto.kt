package com.example.bookinventoryapp.book.data.dto

import kotlinx.serialization.SerialName

data class SearchResultsDto(
    @SerialName("kind") val kind: String,
    @SerialName("totalItems") val totalItems: Int,
    @SerialName("items") val items: List<SearchResultItemDto>,
)
