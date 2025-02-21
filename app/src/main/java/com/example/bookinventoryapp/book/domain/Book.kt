package com.example.bookinventoryapp.book.domain

import java.time.LocalDate

data class Book(
    val id: String,
    val title: String,
    val isbn: String,
    val authors: List<String>,
    val summary: String?,
    var coverByteArray: ByteArray,
    val publisher: String,
    val publishedDate: LocalDate,
    val isbn13: String,
    val isbn10: String,
    val pageCount: Int,
    val categories: List<String>,
    val coverUri: String?,
    val isOwned: Boolean,
    val isOnWishlist: Boolean,
    val notes: String?
)

fun Book.setCover(imageByteArray: ByteArray) {
    this.coverByteArray = imageByteArray
}