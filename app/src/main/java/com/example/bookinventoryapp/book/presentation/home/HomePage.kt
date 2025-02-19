package com.example.bookinventoryapp.book.presentation.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.bookinventoryapp.app.Routes
import com.example.bookinventoryapp.book.domain.Book
import com.example.bookinventoryapp.book.presentation.home.components.HomePageNoBooks
import com.example.bookinventoryapp.book.presentation.home.components.HomePageWithBooks
import com.example.bookinventoryapp.ui.components.AppFloatingActionButton
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomePageRoot(
    viewModel: HomeViewModel = koinViewModel(),
    onBookClick: (Book) -> Unit,
    onWishlistClick: (String) -> Unit,
    onFloatingActionClick: (String) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    viewModel.getBooks()

    HomePageScreen(
        state = state,
        onAction = { action ->
            when (action) {
                is HomeAction.OnBookClick -> onBookClick(action.book)
                is HomeAction.OnWishlistClick -> onWishlistClick(action.route)
                is HomeAction.OnFloatingActionClick -> onFloatingActionClick(action.route)
            }

            viewModel.onAction(action)
        }
    )

}

@Composable
private fun HomePageScreen(
    state: HomeState,
    onAction: (HomeAction) -> Unit
) {
    val isScanning = remember {
        mutableStateOf(false)
    }

    if (state.ownedBooks.isEmpty() && state.wishlistBooks.isEmpty()) {
        HomePageNoBooks(
            modifier = Modifier
                .padding(12.dp, 0.dp)
        )
    } else {
        HomePageWithBooks(
            state.ownedBooks,
            state.wishlistBooks,
            onBookClick = {
                onAction(HomeAction.OnBookClick(it))
            },
            onWishlistClick = {
                onAction(HomeAction.OnWishlistClick(it))
            }
        )

        AppFloatingActionButton(
            imageVector = Icons.Default.Add,
            contentDescription = "Scan Book",
            onClickAction = {
                isScanning.value = true
                onAction(HomeAction.OnFloatingActionClick(Routes.Scan.name))
            }
        )
    }
}


@Preview
@Composable
fun HomePagePreview() {
    val viewModel = koinViewModel<HomeViewModel>()
    viewModel.getBooks()

    val state = HomeState()

    HomePageScreen(
        state,
        { print("action") }
    )
}