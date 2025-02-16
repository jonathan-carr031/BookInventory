package com.example.bookinventoryapp.di

import com.example.bookinventoryapp.book.data.remote.KtorRemoteBookDataSource
import com.example.bookinventoryapp.book.data.remote.RemoteBookDataSource
import com.example.bookinventoryapp.book.data.repository.DefaultBookRepository
import com.example.bookinventoryapp.book.domain.BookRepository
import com.example.bookinventoryapp.book.presentation.book_details.BookDetailsViewModel
import com.example.bookinventoryapp.book.presentation.home.HomeViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single {
        HttpClient(CIO)
        {
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
        }
    }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    viewModelOf(::HomeViewModel)
    viewModelOf(::BookDetailsViewModel)
}