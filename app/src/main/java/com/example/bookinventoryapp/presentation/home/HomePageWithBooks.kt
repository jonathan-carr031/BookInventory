package com.example.bookinventoryapp.presentation.home

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookinventoryapp.R
import com.example.bookinventoryapp.data.Book
import java.time.LocalDate

@Composable
fun HomePageWithBooks(books: List<Book>, modifier: Modifier = Modifier) {
//    var sliderPosition by remember { mutableFloatStateOf(0f) }

//    Column {
//        Slider(
//            value = sliderPosition,
//            onValueChange = { value -> sliderPosition = value },
//            steps = 10,
//            valueRange = 80f..200f
//        )
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = 80.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items(books.count()) { bookIndex ->
            BookImageButton(book = books[bookIndex])
        }
    }
//    }

}

@Preview
@Composable
fun HomePageWithBooksPreview() {
    val books = listOf(
        Book(
            "NRWPDQAAQBAJ",
            "Chocolate War",
            "123456789",
            listOf("Robert Cormier"),
            summary = "Summary",
            cover = painterResource(id = R.drawable.chocolate_war_cover),
            isbn13 = "9780375829871",
            isbn10 = "0375829873",
            publisher = "Ember",
            publishedDate = LocalDate.of(2024, 9, 14),
            pageCount = 274,
            categories = listOf("Young Adult Fiction"),
            coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api")
        ),
        Book(
            "NRWPDQAAQBAJ",
            "Chocolate War",
            "123456789",
            listOf("Robert Cormier"),
            summary = "Summary",
            cover = painterResource(id = R.drawable.chocolate_war_cover),
            isbn13 = "9780375829871",
            isbn10 = "0375829873",
            publisher = "Ember",
            publishedDate = LocalDate.of(2024, 9, 14),
            pageCount = 274,
            categories = listOf("Young Adult Fiction"),
            coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api")
        ),
        Book(
            "NRWPDQAAQBAJ",
            "Chocolate War",
            "123456789",
            listOf("Robert Cormier"),
            summary = "Summary",
            cover = painterResource(id = R.drawable.chocolate_war_cover),
            isbn13 = "9780375829871",
            isbn10 = "0375829873",
            publisher = "Ember",
            publishedDate = LocalDate.of(2024, 9, 14),
            pageCount = 274,
            categories = listOf("Young Adult Fiction"),
            coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api")
        ),
        Book(
            "NRWPDQAAQBAJ",
            "Chocolate War",
            "123456789",
            listOf("Robert Cormier"),
            summary = "Summary",
            cover = painterResource(id = R.drawable.chocolate_war_cover),
            isbn13 = "9780375829871",
            isbn10 = "0375829873",
            publisher = "Ember",
            publishedDate = LocalDate.of(2024, 9, 14),
            pageCount = 274,
            categories = listOf("Young Adult Fiction"),
            coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api")
        )
    )
    HomePageWithBooks(
        books = books
    )
}