package com.example.bookinventoryapp.book.presentation.book_details.components

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookinventoryapp.book.domain.Book
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun BookInfo(
    book: Book
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 200.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .padding(5.dp)
                .weight(2f),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = book.title, style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(3.dp))
                Text(
                    modifier = Modifier
                        .wrapContentWidth(
                            align = Alignment.Start
                        ),
                    text = book.authors.joinToString(", "),
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(Modifier.height(6.dp))
                val publishedDateString =
                    book.publishedDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))
                Text(
                    text = "Published $publishedDateString",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
        if (book.coverByteArray.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxSize()
                    .weight(1f),
                contentAlignment = Alignment.TopCenter,
            ) {
                val bitmapImage =
                    BitmapFactory.decodeByteArray(
                        book.coverByteArray,
                        0,
                        book.coverByteArray.size
                    )
                Image(
                    bitmap = bitmapImage.asImageBitmap(),
                    contentDescription = book.title,
                    modifier = Modifier
                        .aspectRatio(.66f)
                        .clip(
                            RoundedCornerShape(
                                topEnd = 12.dp,
                                topStart = 12.dp,
                                bottomEnd = 12.dp,
                                bottomStart = 12.dp
                            )
                        )
                        .fillMaxSize()
                        .background(Color.LightGray),
                    contentScale = ContentScale.FillBounds
                )
            }
        } else {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxSize()
                    .weight(1f),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    imageVector = Icons.Default.Clear,
                    contentDescription = book.title,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxHeight()
                        .clip(
                            RoundedCornerShape(
                                topEnd = 12.dp,
                                topStart = 12.dp,
                                bottomEnd = 12.dp,
                                bottomStart = 12.dp
                            )
                        )
                        .fillMaxSize()
                        .background(Color.LightGray),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}

@Preview
@Composable
fun BookInfoPreview() {
    val book = Book(
        "NRWPDQAAQBAJ",
        "Chocolate War",
        "123456789",
        listOf("Robert Cormier"),
        coverByteArray = byteArrayOf(),
        summary = "Summary",
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
    BookInfo(book)
}