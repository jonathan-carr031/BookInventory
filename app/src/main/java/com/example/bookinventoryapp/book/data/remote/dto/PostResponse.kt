package com.example.bookinventoryapp.book.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    val body: String,
    val title: String,
    val id: Int,
    val userId: Int
)
