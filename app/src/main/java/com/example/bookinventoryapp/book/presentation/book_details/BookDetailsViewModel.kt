package com.example.bookinventoryapp.book.presentation.book_details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookinventoryapp.book.domain.BookRepository
import com.example.bookinventoryapp.book.domain.setCover
import com.example.bookinventoryapp.core.domain.onError
import com.example.bookinventoryapp.core.domain.onSuccess
import com.example.bookinventoryapp.core.presentation.toUiText
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BookDetailsViewModel(
    private val bookRepository: BookRepository
) : ViewModel() {
    private val _state = MutableStateFlow(BookDetailsState())
    val state = _state
        .onStart {
            if (_state.value.bookIsbn.isNotEmpty()) {
                loadBook(_state.value.bookIsbn)
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    private fun loadBook(isbn: String) = viewModelScope.launch {
        _state.update {
            it.copy(isLoading = true)
        }
        Log.d("Book_Request", "Making a request for $isbn")
        bookRepository.getBookByIsbn(isbn)
            .onSuccess { book ->
                bookRepository.getBookCover(book.id)
                    .onSuccess { coverImage ->
                        book.setCover(coverImage)
                        _state.update {
                            it.copy(
                                isLoading = false,
                                errorMessage = null,
                                selectedBook = book
                            )
                        }
                    }
                    .onError {
                        _state.update {
                            it.copy(
                                isLoading = false,
                                errorMessage = null,
                                selectedBook = book
                            )
                        }
                    }
            }
            .onError { error ->
                _state.update {
                    it.copy(
                        selectedBook = null,
                        isLoading = false,
                        errorMessage = error.toUiText()
                    )
                }
            }
    }
}