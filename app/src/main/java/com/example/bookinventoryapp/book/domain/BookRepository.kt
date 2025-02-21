package com.example.bookinventoryapp.book.domain

import com.example.bookinventoryapp.core.domain.DataError
import com.example.bookinventoryapp.core.domain.Result

interface BookRepository {
    suspend fun getBooks(): Result<List<Book>, DataError.Remote>
    suspend fun getBookByIsbn(isbn: String): Result<Book?, DataError.Remote>
    suspend fun getBookCover(bookId: String): Result<ByteArray, DataError.Remote>
}