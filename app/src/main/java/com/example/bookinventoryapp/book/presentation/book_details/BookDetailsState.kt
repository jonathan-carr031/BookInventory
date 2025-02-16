package com.example.bookinventoryapp.book.presentation.book_details

import com.example.bookinventoryapp.book.domain.Book

data class BookDetailsState(
    val bookIsbn: String = "",
    val selectedBook: Book? = null,
    val isEditing: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
