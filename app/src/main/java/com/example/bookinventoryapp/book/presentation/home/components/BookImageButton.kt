package com.example.bookinventoryapp.book.presentation.home.components

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookinventoryapp.R
import com.example.bookinventoryapp.book.domain.Book
import java.time.LocalDate


@Composable
fun BookImageButton(
    book: Book,
    onClick: () -> Unit
) {
    val bitmapImage =
        BitmapFactory.decodeByteArray(book.coverByteArray, 0, book.coverByteArray.size)
    Box(
        modifier = Modifier
            .padding(5.dp)
            .aspectRatio(.66f),
        contentAlignment = Alignment.Center
    ) {
        Image(
//            bitmap = bitmapImage.asImageBitmap(),
            painter = painterResource(R.drawable.chocolate_war_cover),
            contentDescription = book.title,
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topEnd = 12.dp,
                        topStart = 12.dp,
                        bottomEnd = 12.dp,
                        bottomStart = 12.dp
                    )
                )
                .fillMaxSize()
                .background(Color.LightGray)
                .clickable(onClick = onClick),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview
@Composable
fun BookImageButtonPreview() {
    val book = Book(
        "NRWPDQAAQBAJ",
        "Chocolate War",
        "123456789",
        listOf("Robert Cormier"),
        summary = "Summary",
        coverByteArray = byteArrayOf(),
        isbn13 = "9780375829871",
        isbn10 = "0375829873",
        publisher = "Ember",
        publishedDate = LocalDate.of(2024, 9, 14),
        pageCount = 274,
        categories = listOf("Young Adult Fiction"),
        coverUri = "http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
        isOwned = true,
        isOnWishlist = false,
        notes = null
    )
    BookImageButton(
        book = book,
        onClick = {
            print(book.title)
        }
    )
}