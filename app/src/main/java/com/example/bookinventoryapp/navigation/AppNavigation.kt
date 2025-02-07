package com.example.bookinventoryapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookinventoryapp.presentation.book_details.BookDetails

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "screen1") {
        composable("book_details") { BookDetails() }
    }
}