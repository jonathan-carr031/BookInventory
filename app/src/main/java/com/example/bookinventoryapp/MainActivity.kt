package com.example.bookinventoryapp

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bookinventoryapp.data.Book
import com.example.bookinventoryapp.presentation.drawer.AppNavigationDrawer
import com.example.bookinventoryapp.presentation.home.HomePageNoBooks
import com.example.bookinventoryapp.presentation.home.HomePageWithBooks
import com.example.bookinventoryapp.presentation.topbar.AppTopBar
import com.example.bookinventoryapp.ui.theme.BookInventoryAppTheme
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
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
                    isOnWishlist = false
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
                    isOnWishlist = false
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
                    isOnWishlist = true
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
                    isOnWishlist = false
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
                    isOnWishlist = false
                )
            )

            BookInventoryAppTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

                AppNavigationDrawer(drawerState) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { AppTopBar(drawerState) }
                    ) { innerPadding ->
                        if (books.isEmpty()) {
                            HomePageNoBooks(
                                modifier = Modifier
                                    .padding(innerPadding)
                                    .padding(12.dp, 0.dp)
                            )
                        } else {
                            HomePageWithBooks(
                                books,
                                modifier = Modifier
                                    .padding(innerPadding)
                                    .padding(12.dp, 0.dp)
                            )
                        }

                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            FloatingActionButton(
                                modifier = Modifier
                                    .padding(24.dp)
                                    .align(Alignment.BottomEnd),
                                onClick = {
                                    /*TODO : Navigate to Scan Page*/
                                    Log.d("FloatingActionButton", "floating action button clicked")
                                },
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            ) {
                                Icon(
                                    Icons.Default.Add,
                                    contentDescription = "Scan Book",
                                    tint = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}