package com.example.bookinventoryapp.book.data.remote


import com.example.bookinventoryapp.book.data.dto.SearchResultsDto
import com.example.bookinventoryapp.core.data.safeCall
import com.example.bookinventoryapp.core.domain.DataError
import com.example.bookinventoryapp.core.domain.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter


private const val BASE_URL = "https://www.googleapis.com/books/v1/volumes"
private const val BASE_COVER_URL = "https://books.google.com/books/content"


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
                parameter("key", "AIzaSyAm1Qx_BeM4fX5tKkqxuDPTWgGOpXalKWY")
            }
        }
    }

    override suspend fun getBookCoverImage(
        bookId: String
    ): Result<ByteArray, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = BASE_COVER_URL
            ) {
                parameter("id", bookId)
                parameter("printsec", "frontcover")
                parameter("img", 1)
                parameter("zoom", 1)
                parameter("edge", "curl")
                parameter("source", "gbs_api")
                parameter("key", "AIzaSyAm1Qx_BeM4fX5tKkqxuDPTWgGOpXalKWY")
            }
        }
    }


}