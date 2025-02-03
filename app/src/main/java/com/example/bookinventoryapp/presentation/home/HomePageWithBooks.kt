package com.example.bookinventoryapp.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookinventoryapp.data.Book

@Composable
fun HomePageWithBooks(books: List<Book>, modifier: Modifier = Modifier) {
    val width = 150.dp
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = width),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items(books.count()) { book ->
            BookImageButton(book = books[book], width = width)
        }
    }
}

@Preview
@Composable
fun HomePageWithBooksPreview() {
    val books = listOf(
        Book(
            1,
            "Chocolate War",
            "123456789",
            listOf("Robert Cormier"),
            summary = "Summary",
            cover = Icons.Default.Home
        ),
        Book(
            2,
            "Chocolate War",
            "123456789",
            listOf("Robert Cormier"),
            summary = "Summary",
            cover = Icons.Default.Menu
        ),
        Book(
            3,
            "Chocolate War",
            "123456789",
            listOf("Robert Cormier"),
            summary = "Summary",
            cover = Icons.Default.Settings
        ),
        Book(
            4,
            "Chocolate War",
            "123456789",
            listOf("Robert Cormier"),
            summary = "Summary",
            cover = Icons.Default.AddCircle
        )
    )
    HomePageWithBooks(
        books = books
    )
}