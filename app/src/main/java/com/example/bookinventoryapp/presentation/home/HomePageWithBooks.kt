package com.example.bookinventoryapp.presentation.home

import android.net.Uri
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookinventoryapp.R
import com.example.bookinventoryapp.data.Book
import java.time.LocalDate

@Composable
fun HomePageWithBooks(books: List<Book>, modifier: Modifier = Modifier) {
    val wishListBooks = books.filter { book -> book.isOnWishlist }
    val ownedBooks = books.filter { book -> book.isOwned }

    Column(
        modifier = modifier.padding(0.dp, 12.dp, 0.dp, 0.dp),
    ) {
        Text(
            text = "Wishlist",
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.titleMedium
        )
        Row(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
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
                BookImageButton(wishListBooks[0])
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
                    BookImageButton(book = ownedBooks[bookIndex])
                }
            }
        }

    }

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
            cover = painterResource(id = R.drawable.chocolate_war_cover),
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
            cover = painterResource(id = R.drawable.chocolate_war_cover),
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
            cover = painterResource(id = R.drawable.chocolate_war_cover),
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
        books = books
    )
}