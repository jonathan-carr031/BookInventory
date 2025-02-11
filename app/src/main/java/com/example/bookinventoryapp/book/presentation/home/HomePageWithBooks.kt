package com.example.bookinventoryapp.book.presentation.home

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookinventoryapp.app.Routes
import com.example.bookinventoryapp.book.domain.Book
import com.example.bookinventoryapp.book.presentation.home.components.BookImageButton
import java.time.LocalDate

@Composable
fun HomePageWithBooks(
    wishListBooks: List<Book>,
    ownedBooks: List<Book>,
    onBookClick: (Book) -> Unit,
    onWishlistClick: (String) -> Unit
) {
    Column(
        modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp),
    ) {
        Text(
            text = "Wishlist",
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.titleMedium
        )
        Row(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (wishListBooks.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically),
                ) {
                    Text(text = "You have no books on your wishlist")
                }
            } else {
                for ((index, book) in wishListBooks.withIndex()) {
                    if (index > 10) {
                        break
                    }
                    BookImageButton(
                        book,
                        onClick = {
                            onBookClick(book)
                        }
                    )
                }
                if (wishListBooks.size > 10) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Go to Wishlist",
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.clickable {
                            onWishlistClick(Routes.Wishlist.name)
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "My Books",
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.titleMedium
        )

        if (ownedBooks.isEmpty()) {
            Text(text = "You have no books")
        } else {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 80.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                items(ownedBooks.count()) { bookIndex ->
                    val book = ownedBooks[bookIndex]
                    BookImageButton(
                        book = book,
                        onClick = {
                            onBookClick(book)
                        })
                }
            }
        }

    }

}

@Preview
@Composable
fun HomePageWithBooksPreview() {
    val ownedBooks = listOf(
        Book(
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
            coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"),
            isOwned = true,
            isOnWishlist = false,
            notes = null
        ),
        Book(
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
            coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"),
            isOwned = true,
            isOnWishlist = false,
            notes = null
        ),
        Book(
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
            coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"),
            isOwned = false,
            isOnWishlist = true,
            notes = null
        ),
        Book(
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
            coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"),
            isOwned = true,
            isOnWishlist = false,
            notes = null
        )
    )
    val wishlistBooks = listOf(
        Book(
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
            coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"),
            isOwned = true,
            isOnWishlist = false,
            notes = null
        ),
        Book(
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
            coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"),
            isOwned = true,
            isOnWishlist = false,
            notes = null
        ),
        Book(
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
            coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"),
            isOwned = false,
            isOnWishlist = true,
            notes = null
        ),
        Book(
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
            coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"),
            isOwned = true,
            isOnWishlist = false,
            notes = null
        )
    )
    HomePageWithBooks(
        ownedBooks,
        wishlistBooks,
        onBookClick = {},
        onWishlistClick = {}
    )
}