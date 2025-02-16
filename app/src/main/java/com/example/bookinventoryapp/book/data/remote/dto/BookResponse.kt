package com.example.bookinventoryapp.book.data.remote.dto

import com.example.bookinventoryapp.book.domain.Book
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class BookResponse(
    val id: String,
    val volumeInfo: VolumeInfo
)


fun BookResponse.toBook(): Book {
    return Book(
        this.id,
        this.volumeInfo.title,
        "123456789",
        this.volumeInfo.authors,
        summary = "Summary",
        coverByteArray = byteArrayOf(),
        isbn13 = "9780375829871",
        isbn10 = "0375829873",
        publisher = this.volumeInfo.publisher,
        publishedDate = LocalDate.of(2024, 9, 14),
        pageCount = 274,
        categories = listOf("Young Adult Fiction"),
        coverUri = "http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
        isOwned = false,
        isOnWishlist = false,
        notes = null
    )
}