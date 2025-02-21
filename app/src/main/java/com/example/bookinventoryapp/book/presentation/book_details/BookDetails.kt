package com.example.bookinventoryapp.book.presentation.book_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.bookinventoryapp.book.presentation.book_details.components.BookInfo
import com.example.bookinventoryapp.book.presentation.book_details.components.BookNotes
import com.example.bookinventoryapp.book.presentation.book_details.components.BookSummary
import com.example.bookinventoryapp.core.presentation.ErrorMessage
import com.example.bookinventoryapp.core.presentation.Loading
import com.example.bookinventoryapp.ui.components.AppFloatingActionButton
import org.koin.androidx.compose.koinViewModel


@Composable
fun BookDetails(
    viewModel: BookDetailsViewModel = koinViewModel(),
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    val book = state.selectedBook

    if (state.isLoading) {
        return Loading()
    }

    if (!state.errorMessage.isNullOrBlank()) {
        return ErrorMessage(state.errorMessage.toString())
    }

    if (book != null) {
        Column(
            modifier = Modifier
                .padding(top = 6.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            BookInfo(book)

            if (book.summary != null) {
                BookSummary(book.summary)
            }

            if (book.notes != null) {
                BookNotes(book.notes)
            }
        }
        AppFloatingActionButton(
            imageVector = Icons.Default.Edit,
            contentDescription = "Edit",
            onClickAction = { /*TODO navigate to edit details page*/ },
        )
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text(text = "No Book Found with ISBN: ${state.bookIsbn}")
                Button(
                    onClick = {}
                ) {
                    Text(text = "Add One")
                }
            }
        }
    }

}