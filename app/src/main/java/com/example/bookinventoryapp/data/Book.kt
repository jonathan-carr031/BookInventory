package com.example.bookinventoryapp.data

import android.net.Uri
import androidx.compose.ui.graphics.painter.Painter
import java.time.LocalDate

class Book(
    val id: String,
    val title: String,
    val isbn: String,
    val authors: List<String>,
    val summary: String?,
    val cover: Painter,
    val publisher : String,
    val publishedDate : LocalDate,
    val isbn13 : String,
    val isbn10 : String,
    val pageCount : Int,
    val categories : List<String>,
    val coverUri : Uri
)