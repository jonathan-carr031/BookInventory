package com.example.bookinventoryapp.book.data.mappers

import com.example.bookinventoryapp.book.data.dto.SearchResultItemDto
import com.example.bookinventoryapp.book.domain.Book
import java.time.LocalDate

fun SearchResultItemDto.toBook(): Book {
    return Book(
        id = this.id,
        title = this.volumeInfo.title,
        isbn = "123456789",
        authors = this.volumeInfo.authors,
        summary = this.volumeInfo.description,
        coverByteArray = byteArrayOf(),
        isbn13 = this.volumeInfo.industryIdentifiers.first { item -> item.type == "ISBN_13" }.identifier,
        isbn10 = this.volumeInfo.industryIdentifiers.first { item -> item.type == "ISBN_10" }.identifier,
        publisher = this.volumeInfo.publisher,
        publishedDate = LocalDate.of(2024, 9, 14),
        pageCount = this.volumeInfo.pageCount,
        categories = this.volumeInfo.authors,
        coverUri = this.volumeInfo.imageLinks.thumbnail,
        isOwned = false,
        isOnWishlist = false,
        notes = null
    )
}