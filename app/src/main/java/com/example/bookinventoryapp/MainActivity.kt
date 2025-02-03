package com.example.bookinventoryapp

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
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bookinventoryapp.data.Book
import com.example.bookinventoryapp.presentation.home.HomePageNoBooks
import com.example.bookinventoryapp.presentation.home.HomePageWithBooks
import com.example.bookinventoryapp.ui.theme.BookInventoryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val books = listOf(
                Book(
                    1,
                    "Chocolate War",
                    "123456789",
                    listOf("Robert Cormier"),
                    summary = "Summary",
                    cover = Icons.Default.Home
                )
            )
            BookInventoryAppTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                ModalNavigationDrawer(
                    drawerContent = {
                        ModalDrawerSheet {
                            Column(
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                                    .verticalScroll(rememberScrollState())
                            ) {
                                Spacer(Modifier.height(12.dp))
                                Text(
                                    "Drawer Title",
                                    modifier = Modifier.padding(16.dp),
                                    style = MaterialTheme.typography.titleLarge
                                )
                                HorizontalDivider()

                                Text(
                                    "Section 1",
                                    modifier = Modifier.padding(16.dp),
                                    style = MaterialTheme.typography.titleMedium
                                )
                                NavigationDrawerItem(
                                    label = { Text("Item 1") },
                                    selected = false,
                                    onClick = { /* Handle click */ }
                                )
                                NavigationDrawerItem(
                                    label = { Text("Item 2") },
                                    selected = false,
                                    onClick = { /* Handle click */ }
                                )

                                HorizontalDivider(
                                    modifier = Modifier.padding(
                                        vertical = 8.dp
                                    )
                                )

                                Text(
                                    "Section 2",
                                    modifier = Modifier.padding(16.dp),
                                    style = MaterialTheme.typography.titleMedium
                                )
                                NavigationDrawerItem(
                                    label = { Text("Settings") },
                                    selected = false,
                                    icon = {
                                        Icon(
                                            Icons.Outlined.Settings,
                                            contentDescription = null
                                        )
                                    },
                                    badge = { Text("20") }, // Placeholder
                                    onClick = { /* Handle click */ }
                                )
                                NavigationDrawerItem(
                                    label = { Text("Help and feedback") },
                                    selected = false,
                                    icon = {
                                        Icon(
                                            Icons.AutoMirrored.Outlined.ArrowBack,
                                            contentDescription = null
                                        )
                                    },
                                    onClick = { /* Handle click */ },
                                )
                                Spacer(Modifier.height(12.dp))
                            }
                        }
                    },
                    drawerState = drawerState
                ) {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        if (books.isEmpty()) {
                            HomePageNoBooks(
                                modifier = Modifier.padding(innerPadding)
                            )
                        } else {
                            HomePageWithBooks(books)
                        }
                    }
                }

            }
        }
    }
}