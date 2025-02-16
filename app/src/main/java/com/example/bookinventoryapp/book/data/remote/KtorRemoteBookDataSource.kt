package com.example.bookinventoryapp.book.data.remote


import com.example.bookinventoryapp.book.data.dto.SearchResultsDto
import com.example.bookinventoryapp.core.data.safeCall
import com.example.bookinventoryapp.core.domain.DataError
import com.example.bookinventoryapp.core.domain.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter


private const val BASE_URL = "https://www.googleapis.com/books/v1/volumes"


class KtorRemoteBookDataSource(
    private val httpClient: HttpClient
) : RemoteBookDataSource {
    override suspend fun getBooksByIsbn(
        isbn: String
    ): Result<SearchResultsDto, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = BASE_URL
            ) {
                parameter("q", "isbn:$isbn")
            }
        }
    }
}