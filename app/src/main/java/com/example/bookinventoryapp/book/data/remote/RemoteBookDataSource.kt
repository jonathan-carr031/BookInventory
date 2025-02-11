package com.example.bookinventoryapp.book.data.remote

import com.example.bookinventoryapp.book.data.dto.SearchResultsDto
import com.example.bookinventoryapp.core.domain.DataError
import com.example.bookinventoryapp.core.domain.Result

interface RemoteBookDataSource {
    suspend fun getBooksByIsbn(isbn: String): Result<SearchResultsDto, DataError.Remote>
}