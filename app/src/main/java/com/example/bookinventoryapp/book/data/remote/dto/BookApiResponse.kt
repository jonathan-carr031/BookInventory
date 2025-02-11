package com.example.bookinventoryapp.book.data.remote.dto

import kotlinx.serialization.Serializable


@Serializable
data class BookApiResponse(
    val kind: String,
    val totalItems: Int,
    val items: List<BookResponse>
)