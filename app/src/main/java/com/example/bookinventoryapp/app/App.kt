package com.example.bookinventoryapp.app

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.bookinventoryapp.book.presentation.book_details.BookDetails
import com.example.bookinventoryapp.book.presentation.book_details.BookDetailsViewModel
import com.example.bookinventoryapp.book.presentation.drawer.AppNavigationDrawer
import com.example.bookinventoryapp.book.presentation.home.HomePageRoot
import com.example.bookinventoryapp.book.presentation.home.HomeViewModel
import com.example.bookinventoryapp.book.presentation.scanner.presentation.ScannerScreen
import com.example.bookinventoryapp.book.presentation.topbar.AppTopBar
import com.example.bookinventoryapp.book.presentation.wishlist.WishlistScreen
import com.example.bookinventoryapp.ui.theme.BookInventoryAppTheme
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun App() {
    BookInventoryAppTheme {
        val navController: NavHostController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()

        val currentScreen = Routes.Home

        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

        val canNavigateBack = remember {
            mutableStateOf(false)
        }

//        var canNavigateBack = navController.previousBackStackEntry != null

        AppNavigationDrawer(drawerState, navController) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    AppTopBar(
                        currentScreen,
                        drawerState,
                        canNavigateBack = canNavigateBack.value,
                        navigateUp = {
                            navController.navigateUp()
                        }
                    )
                }
            ) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = Route.BookGraph,
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
                    navigation<Route.BookGraph>(
                        startDestination = Route.Home
                    ) {

                        composable<Route.Home> {
                            val viewModel = koinViewModel<HomeViewModel>()
                            HomePageRoot(
                                viewModel = viewModel,
                                onBookClick = { book ->
                                    Log.d("HomePageEvent", "onBookClick")
                                    navController.navigate(
                                        Route.BookDetails(book.id)
                                    )
                                },
                                onWishlistClick = {
                                    Log.d("HomePageEvent", "onWishlistClick")
                                    navController.navigate(
                                        Route.Wishlist
                                    )
                                },
                                onFloatingActionClick = {
                                    navController.navigate(
                                        Route.BarcodeScanner
                                    )
                                }
                            )
                        }
                        composable<Route.BookDetails> { entry ->
                            val args = entry.toRoute<Route.BookDetails>()
                            Log.d("Navigation", "Book id is ${args.bookId}")
                            val viewmodel = koinViewModel<BookDetailsViewModel>()
                            viewmodel.state.value.bookIsbn = args.bookId
                            BookDetails(viewmodel)
                        }
                        composable<Route.Wishlist> {
                            WishlistScreen()
                        }
                        composable<Route.BarcodeScanner> {
                            ScannerScreen(
                                onBarcodeDetected = { barcode ->
                                    Log.d("Barcode Detected", barcode)
                                    navController.navigate(
                                        Route.BookDetails(barcode)
                                    ) {
                                        popUpTo(Route.BarcodeScanner) {
                                            inclusive = true
                                        }
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}