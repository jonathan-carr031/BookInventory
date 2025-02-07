package com.example.bookinventoryapp.ui

import androidx.lifecycle.ViewModel
import com.example.bookinventoryapp.data.Book
import com.example.bookinventoryapp.data.HomePageUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomePageUiState(books = getBooks()))
    val uiState: StateFlow<HomePageUiState> = _uiState.asStateFlow()


    private fun getBooks(): List<Book> {
        return listOf(
//            Book(
//                "NRWPDQAAQBAJ",
//                "Chocolate War",
//                "123456789",
//                listOf("Robert Cormier"),
//                summary = "Summary",
//                cover = R.drawable.chocolate_war_cover,
//                isbn13 = "9780375829871",
//                isbn10 = "0375829873",
//                publisher = "Ember",
//                publishedDate = LocalDate.of(2024, 9, 14),
//                pageCount = 274,
//                categories = listOf("Young Adult Fiction"),
//                coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"),
//                isOwned = true,
//                isOnWishlist = false,
//                notes = null
//            ),
//            Book(
//                "NRWPDQAAQBAJ",
//                "Chocolate War",
//                "123456789",
//                listOf("Robert Cormier"),
//                summary = "Summary",
//                cover = R.drawable.chocolate_war_cover,
//                isbn13 = "9780375829871",
//                isbn10 = "0375829873",
//                publisher = "Ember",
//                publishedDate = LocalDate.of(2024, 9, 14),
//                pageCount = 274,
//                categories = listOf("Young Adult Fiction"),
//                coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"),
//                isOwned = true,
//                isOnWishlist = false,
//                notes = null
//            ),
//            Book(
//                "NRWPDQAAQBAJ",
//                "Chocolate War",
//                "123456789",
//                listOf("Robert Cormier"),
//                summary = "Summary",
//                cover = R.drawable.chocolate_war_cover,
//                isbn13 = "9780375829871",
//                isbn10 = "0375829873",
//                publisher = "Ember",
//                publishedDate = LocalDate.of(2024, 9, 14),
//                pageCount = 274,
//                categories = listOf("Young Adult Fiction"),
//                coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"),
//                isOwned = false,
//                isOnWishlist = true,
//                notes = null
//            ),
//            Book(
//                "NRWPDQAAQBAJ",
//                "Chocolate War",
//                "123456789",
//                listOf("Robert Cormier"),
//                summary = "Summary",
//                cover = R.drawable.chocolate_war_cover,
//                isbn13 = "9780375829871",
//                isbn10 = "0375829873",
//                publisher = "Ember",
//                publishedDate = LocalDate.of(2024, 9, 14),
//                pageCount = 274,
//                categories = listOf("Young Adult Fiction"),
//                coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"),
//                isOwned = true,
//                isOnWishlist = false,
//                notes = null
//            ),
//            Book(
//                "NRWPDQAAQBAJ",
//                "Chocolate War",
//                "123456789",
//                listOf("Robert Cormier"),
//                summary = "Summary",
//                cover = R.drawable.chocolate_war_cover,
//                isbn13 = "9780375829871",
//                isbn10 = "0375829873",
//                publisher = "Ember",
//                publishedDate = LocalDate.of(2024, 9, 14),
//                pageCount = 274,
//                categories = listOf("Young Adult Fiction"),
//                coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"),
//                isOwned = false,
//                isOnWishlist = false,
//                notes = null
//            )
        )
    }
}