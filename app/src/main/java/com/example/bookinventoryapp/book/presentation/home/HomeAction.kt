package com.example.bookinventoryapp.book.presentation.home

import com.example.bookinventoryapp.book.domain.Book

sealed interface HomeAction {
    data class OnBookClick(val book: Book) : HomeAction
    data class OnWishlistClick(val route: String) : HomeAction
    data class OnFloatingActionClick(val route: String) : HomeAction
}