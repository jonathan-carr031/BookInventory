package com.example.bookinventoryapp.book.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.bookinventoryapp.book.domain.Book
import com.example.bookinventoryapp.ui.components.AppFloatingActionButton
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomePageRoot(
    viewModel: HomeViewModel = koinViewModel(),
    onBookClick: (Book) -> Unit,
    onWishlistClick: (String) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    viewModel.getBooks()

    HomePageScreen(
        state = state,
        onAction = { action ->
            when (action) {
                is HomeAction.OnBookClick -> onBookClick(action.book)
                is HomeAction.OnWishlistClick -> onWishlistClick(action.route)
                else -> Unit
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
                /*TODO : Navigate to Scan Page*/
                Log.d(
                    "FloatingActionButton",
                    "floating action button clicked"
                )
            }
        )
    }
}


@Preview
@Composable
fun HomePagePreview() {
    val viewModel = HomeViewModel()
    viewModel.getBooks()

    val state = HomeState()

    HomePageScreen(
        state,
        { print("action") }
    )
}