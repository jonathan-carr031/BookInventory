package com.example.bookinventoryapp

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bookinventoryapp.data.Book
import com.example.bookinventoryapp.presentation.drawer.AppNavigationDrawer
import com.example.bookinventoryapp.presentation.home.HomePageNoBooks
import com.example.bookinventoryapp.presentation.home.HomePageWithBooks
import com.example.bookinventoryapp.presentation.topbar.AppTopBar
import com.example.bookinventoryapp.ui.theme.BookInventoryAppTheme
import kotlinx.coroutines.launch
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            val books : List<Book> = emptyList()
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
                    }
                }
            }
        }
    }
}