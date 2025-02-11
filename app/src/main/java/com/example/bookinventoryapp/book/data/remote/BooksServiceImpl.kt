package com.example.bookinventoryapp.book.data.remote

import android.util.Log
import com.example.bookinventoryapp.book.data.remote.dto.BookApiResponse
import com.example.bookinventoryapp.book.data.remote.dto.toBook
import com.example.bookinventoryapp.book.domain.Book
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class BooksServiceImpl(
    private val client: HttpClient
) : BooksService {
    override suspend fun getBookByIsbn(isbn: String): List<Book> {
        try {
            val httpResponse: HttpResponse =
                client.get(urlString = "https://www.googleapis.com/books/v1/volumes") {
                    url {
                        parameters.append("q", "isbn:$isbn")
                    }
                }

            val bookResponse: BookApiResponse = httpResponse.body()

            var books: List<Book> = listOf()

            for (book in bookResponse.items) {
                books = books + book.toBook()
            }

            return books
        } catch (e: RedirectResponseException) {
            //3XX Response
            Log.e("client_call", e.response.status.description)
            return emptyList()
        } catch (e: ClientRequestException) {
            //4XX Response
            Log.e("client_call", e.response.status.description)
            return emptyList()
        } catch (e: ServerResponseException) {
            //5XX Response
            Log.e("client_call", e.response.status.description)
            return emptyList()
        } catch (e: Exception) {
            // Everything else
            Log.e("client_call", "$e.message")
            return emptyList()
        }
    }

}