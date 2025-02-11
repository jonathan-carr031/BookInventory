package com.example.bookinventoryapp.book.presentation.home

import com.example.bookinventoryapp.book.domain.Book

data class HomeState(
    val ownedBooks: List<Book> = emptyList(),
    val wishlistBooks: List<Book> = emptyList(),
    val searchQuery: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)