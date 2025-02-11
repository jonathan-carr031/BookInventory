package com.example.bookinventoryapp.app

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object BookGraph : Route

    @Serializable
    data object Home : Route

    @Serializable
    data class BookDetails(val bookId: String) : Route

    @Serializable
    data object Wishlist : Route
}