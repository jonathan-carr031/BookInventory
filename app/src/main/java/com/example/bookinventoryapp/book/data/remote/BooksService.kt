package com.example.bookinventoryapp.book.data.remote

import com.example.bookinventoryapp.book.domain.Book
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface BooksService {
    suspend fun getBookByIsbn(isbn: String): List<Book>
//    suspend fun getBookByAuthor(isbn: String): BookApiResponse?
//    suspend fun getBookByTitle(isbn: String): BookApiResponse?


    companion object {
        fun create(): BooksService {
            return BooksServiceImpl(client = HttpClient(CIO) {
                install(Logging) {
                    level = LogLevel.ALL
                }
                install(HttpTimeout) {
                    requestTimeoutMillis = 60000
                }
                install(ContentNegotiation) {
                    json(Json {
                        ignoreUnknownKeys = true
                    })
                }
            })
        }
    }
}