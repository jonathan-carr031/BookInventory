package com.example.bookinventoryapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.bookinventoryapp.app.Route
import com.example.bookinventoryapp.book.presentation.book_details.BookDetails
import com.example.bookinventoryapp.book.presentation.book_details.BookDetailsViewModel
import com.example.bookinventoryapp.book.presentation.home.HomePageRoot
import com.example.bookinventoryapp.book.presentation.home.HomeViewModel
import com.example.bookinventoryapp.book.presentation.scanner.presentation.ScannerScreen
import com.example.bookinventoryapp.book.presentation.wishlist.WishlistScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Route.BookGraph,
        modifier = modifier
    ) {
        navigation<Route.BookGraph>(
            startDestination = Route.Home
        ) {
            composable<Route.Home> {
                val viewModel = koinViewModel<HomeViewModel>()
                HomePageRoot(
                    viewModel = viewModel,
                    onBookClick = { book ->
                        navController.navigate(
                            Route.BookDetails(book.id)
                        ) {
                            launchSingleTop = true
                        }
                    },
                    onWishlistClick = {
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
                        navController.navigate(
                            Route.BookDetails(barcode)
                        ) {
                            popUpTo(Route.BarcodeScanner) {
                                inclusive = true
                            }

                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}