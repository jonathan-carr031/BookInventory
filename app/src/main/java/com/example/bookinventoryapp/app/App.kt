package com.example.bookinventoryapp.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bookinventoryapp.book.presentation.drawer.AppNavigationDrawer
import com.example.bookinventoryapp.book.presentation.topbar.AppTopBar
import com.example.bookinventoryapp.navigation.AppNavigation
import com.example.bookinventoryapp.ui.theme.BookInventoryAppTheme

@Preview
@Composable
fun App() {
    BookInventoryAppTheme {
        val navController: NavHostController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()

        val currentDestination = currentBackStack?.destination

        val currentScreen =
            Routes.entries.find { currentDestination?.route.toString().contains(it.name) }
                ?: Routes.Home

        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

        val canNavigateBack = navController.previousBackStackEntry != null

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
                AppNavigation(
                    navController = navController,
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                )
            }
        }
    }
}