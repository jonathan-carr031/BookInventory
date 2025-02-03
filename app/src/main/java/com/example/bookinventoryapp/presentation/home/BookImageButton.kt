package com.example.bookinventoryapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.bookinventoryapp.data.Book

@Composable
fun BookImageButton(book: Book, width: Dp) {
    val height = width + width

    Box(
        modifier = Modifier.padding(10.dp,10.dp,0.dp,0.dp)
    ) {
        Image(
            imageVector = book.cover,
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
                .size(width, height)
                .background(Color.Yellow)
                .clickable(onClick = { print(book.id) }),
            contentScale = ContentScale.FillHeight
        )
    }
}

@Preview
@Composable
fun BookImageButtonPreview() {
    val book = Book(
        1,
        "Chocolate War",
        "123456789",
        listOf("Robert Cormier"),
        summary = "Summary",
        cover = Icons.Default.Home
    )
    BookImageButton(book = book, 150.dp)
}