package com.example.bookinventoryapp.data

import androidx.compose.ui.graphics.vector.ImageVector

class Book(
    val id: Int,
    val title: String,
    val isbn: String,
    val authors: List<String>,
    val summary: String?,
    val cover: ImageVector
)