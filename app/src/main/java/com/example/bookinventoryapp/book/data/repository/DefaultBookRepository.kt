package com.example.bookinventoryapp.book.data.repository

import com.example.bookinventoryapp.book.data.mappers.toBook
import com.example.bookinventoryapp.book.data.remote.RemoteBookDataSource
import com.example.bookinventoryapp.book.domain.Book
import com.example.bookinventoryapp.book.domain.BookRepository
import com.example.bookinventoryapp.core.domain.DataError
import com.example.bookinventoryapp.core.domain.Result
import com.example.bookinventoryapp.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource
) : BookRepository {

    override suspend fun getBooks(): Result<List<Book>, DataError.Remote> {
        TODO("Not yet implemented")
    }

    override suspend fun getBookByIsbn(isbn: String): Result<Book, DataError.Remote> {
        val result = remoteBookDataSource.getBooksByIsbn(isbn)
            .map { dto ->
                dto.items.map {
                    it.toBook()
                }.first()
            }

        return result

    }

    override suspend fun getBookCover(bookId: String): Result<ByteArray, DataError.Remote> {
        return remoteBookDataSource.getBookCoverImage(bookId)
    }
}