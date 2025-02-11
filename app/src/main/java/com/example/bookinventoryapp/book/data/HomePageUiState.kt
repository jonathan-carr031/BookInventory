package com.example.bookinventoryapp.book.data

import com.example.bookinventoryapp.book.domain.Book

data class HomePageUiState(
    val books: List<Book> = listOf()
)
