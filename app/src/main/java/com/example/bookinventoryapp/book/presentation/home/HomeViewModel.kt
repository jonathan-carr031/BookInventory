package com.example.bookinventoryapp.book.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.bookinventoryapp.book.domain.Book
import com.example.bookinventoryapp.book.domain.BookRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import java.time.LocalDate

@OptIn(FlowPreview::class)
class HomeViewModel(
    private val bookRepository: BookRepository
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    fun onAction(action: HomeAction) {
        when (action) {
            is HomeAction.OnBookClick -> {
                Log.d("ViewModel Call", "OnBookClick::Action Happened")
            }

            is HomeAction.OnWishlistClick -> {
                Log.d("ViewModel Call", "OnWishlistClick::Action Happened")
            }

            is HomeAction.OnFloatingActionClick -> {
                Log.d("ViewModel Call", "OnFloatingActionClick::Action Happened")
            }
        }
    }

    fun getBooks() {

//        bookRepository.getBooks()

        var books = emptyList<Book>()
        for (i in 1..50) {
            books = books + Book(
                "NRWPDQAAQBAJ",
                "Chocolate War",
                "123456789",
                listOf("Robert Cormier"),
                summary = "Summary",
                coverByteArray = byteArrayOf(),
                isbn13 = "9780375829871",
                isbn10 = "0375829873",
                publisher = "Ember",
                publishedDate = LocalDate.of(2024, 9, 14),
                pageCount = 274,
                categories = listOf("Young Adult Fiction"),
                coverUri = "http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                isOwned = true,
                isOnWishlist = false,
                notes = null
            )
        }

        _state.update {
            it.copy(
                ownedBooks = books,
                wishlistBooks = books
            )
        }
    }

    private fun observeSearchQuery() {
        state.map {
            it.searchQuery
        }
            .distinctUntilChanged()
            .debounce(500L)
            .onEach { query ->
                when {
                    query.isBlank() -> {
                        _state.update {
                            it.copy(
                                errorMessage = null,
                                ownedBooks = listOf(
                                    Book(
                                        "NRWPDQAAQBAJ",
                                        "Chocolate War",
                                        "123456789",
                                        listOf("Robert Cormier"),
                                        summary = "Summary",
                                        coverByteArray = byteArrayOf(),
                                        isbn13 = "9780375829871",
                                        isbn10 = "0375829873",
                                        publisher = "Ember",
                                        publishedDate = LocalDate.of(2024, 9, 14),
                                        pageCount = 274,
                                        categories = listOf("Young Adult Fiction"),
                                        coverUri = "http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                                        isOwned = true,
                                        isOnWishlist = false,
                                        notes = null
                                    ),
                                    Book(
                                        "NRWPDQAAQBAJ",
                                        "Chocolate War",
                                        "123456789",
                                        listOf("Robert Cormier"),
                                        summary = "Summary",
                                        coverByteArray = byteArrayOf(),
                                        isbn13 = "9780375829871",
                                        isbn10 = "0375829873",
                                        publisher = "Ember",
                                        publishedDate = LocalDate.of(2024, 9, 14),
                                        pageCount = 274,
                                        categories = listOf("Young Adult Fiction"),
                                        coverUri = "http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                                        isOwned = true,
                                        isOnWishlist = false,
                                        notes = null
                                    ),
                                    Book(
                                        "NRWPDQAAQBAJ",
                                        "Chocolate War",
                                        "123456789",
                                        listOf("Robert Cormier"),
                                        summary = "Summary",
                                        coverByteArray = byteArrayOf(),
                                        isbn13 = "9780375829871",
                                        isbn10 = "0375829873",
                                        publisher = "Ember",
                                        publishedDate = LocalDate.of(2024, 9, 14),
                                        pageCount = 274,
                                        categories = listOf("Young Adult Fiction"),
                                        coverUri = "http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                                        isOwned = false,
                                        isOnWishlist = true,
                                        notes = null
                                    ),
                                    Book(
                                        "NRWPDQAAQBAJ",
                                        "Chocolate War",
                                        "123456789",
                                        listOf("Robert Cormier"),
                                        summary = "Summary",
                                        coverByteArray = byteArrayOf(),
                                        isbn13 = "9780375829871",
                                        isbn10 = "0375829873",
                                        publisher = "Ember",
                                        publishedDate = LocalDate.of(2024, 9, 14),
                                        pageCount = 274,
                                        categories = listOf("Young Adult Fiction"),
                                        coverUri = "http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                                        isOwned = true,
                                        isOnWishlist = false,
                                        notes = null
                                    ),
                                    Book(
                                        "NRWPDQAAQBAJ",
                                        "Chocolate War",
                                        "123456789",
                                        listOf("Robert Cormier"),
                                        summary = "Summary",
                                        coverByteArray = byteArrayOf(),
                                        isbn13 = "9780375829871",
                                        isbn10 = "0375829873",
                                        publisher = "Ember",
                                        publishedDate = LocalDate.of(2024, 9, 14),
                                        pageCount = 274,
                                        categories = listOf("Young Adult Fiction"),
                                        coverUri = "http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                                        isOwned = false,
                                        isOnWishlist = false,
                                        notes = null
                                    )
                                )
                            )
                        }
                    }
                }
            }
    }
}