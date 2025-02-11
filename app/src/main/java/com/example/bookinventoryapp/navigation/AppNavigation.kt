package com.example.bookinventoryapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bookinventoryapp.app.Routes
import com.example.bookinventoryapp.book.presentation.book_details.BookDetails

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    canNavigateBack: Boolean,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home.name,
        modifier = modifier
            .fillMaxSize()
    ) {
        composable(route = Routes.Home.name) {

        }
        composable(route = Routes.BookDetails.name) {
            BookDetails()
        }
    }
}