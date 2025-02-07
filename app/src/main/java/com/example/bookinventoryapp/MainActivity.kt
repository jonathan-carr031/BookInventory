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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bookinventoryapp.data.Book
import com.example.bookinventoryapp.navigation.Routes
import com.example.bookinventoryapp.presentation.book_details.BookDetails
import com.example.bookinventoryapp.presentation.drawer.AppNavigationDrawer
import com.example.bookinventoryapp.presentation.home.HomePageNoBooks
import com.example.bookinventoryapp.presentation.home.HomePageWithBooks
import com.example.bookinventoryapp.presentation.topbar.AppTopBar
import com.example.bookinventoryapp.ui.HomeScreenViewModel
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
                    isOnWishlist = false,
                    notes = null
                )
            )

            val viewModel: HomeScreenViewModel = viewModel()
            val navController: NavHostController = rememberNavController()
            val backStackEntry by navController.currentBackStackEntryAsState()

            val currentScreen = Routes.valueOf(
                backStackEntry?.destination?.route ?: Routes.Home.name
            )

            BookInventoryAppTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                var canNavigateBack = navController.previousBackStackEntry != null

                AppNavigationDrawer(drawerState, navController) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            AppTopBar(
                                currentScreen,
                                drawerState,
                                canNavigateBack = canNavigateBack,
                                navigateUp = {
                                    navController.navigateUp()
                                }
                            )
                        }
                    ) { innerPadding ->
                        val uiState by viewModel.uiState.collectAsState()

                        NavHost(
                            navController = navController,
                            startDestination = Routes.Home.name,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable(route = Routes.Home.name) {
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
                                            Log.d(
                                                "FloatingActionButton",
                                                "floating action button clicked"
                                            )
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
                            composable(route = Routes.BookDetails.name) {
                                canNavigateBack = true
                                BookDetails()
                            }
                        }
                    }
                }
            }
        }
    }
}