package com.example.bookinventoryapp.presentation.book_details

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookinventoryapp.R
import com.example.bookinventoryapp.data.Book
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun BookDetails() {
    val book = Book(
        "NRWPDQAAQBAJ",
        "Chocolate War",
        "123456789",
        authors = listOf("Robert Cormier", "Bryan Adams"),
        summary = "One of the most controversial YA novels of all time, The Chocolate War is a modern masterpiece that speaks to fans of S. E. Hinton’s The Outsiders and John Knowles’s A Separate Peace. After suffering rejection from seven major publishers, The Chocolate War made its debut in 1974, and quickly became a bestselling—and provocative—classic for young adults. This chilling portrait of an all-boys prep school casts an unflinching eye on the pitfalls of conformity and corruption in our most elite cultural institutions. “Masterfully structured and rich in theme; the action is well crafted, well timed, suspenseful.”—The New York Times Book Review “The characterizations of all the boys are superb.”—School Library Journal, starred review “Compellingly immediate. . . . Readers will respect the uncompromising ending.”—Kirkus Reviews, starred review An ALA Best Book for Young Adults A School Library Journal Best Book of the Year A Kirkus Reviews Editor’s Choice A New York Times Outstanding Book of the Year",
        cover = painterResource(id = R.drawable.chocolate_war_cover),
        isbn13 = "9780375829871",
        isbn10 = "0375829873",
        publisher = "Ember",
        publishedDate = LocalDate.of(2024, 9, 14),
        pageCount = 274,
        categories = listOf("Young Adult Fiction"),
        coverUri = Uri.parse("http://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"),
        isOwned = true,
        isOnWishlist = false,
        notes = "I loved this book"
    )

    val expanded = true

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                    ) {
                        Column {
                            Text(text = book.title, style = MaterialTheme.typography.titleMedium)
                            Text(
                                text = book.authors.joinToString(", "),
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = book.publishedDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .aspectRatio(.66f),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = book.cover,
                            contentDescription = book.title,
                            modifier = Modifier
                                .clip(
                                    RoundedCornerShape(
                                        topEnd = 12.dp,
                                        topStart = 12.dp,
                                        bottomEnd = 12.dp,
                                        bottomStart = 12.dp
                                    )
                                )
                                .fillMaxSize()
                                .background(Color.LightGray),
                            contentScale = ContentScale.FillBounds
                        )
                    }
                }
                if (book.summary != null) {
                    var rowModifier = Modifier
                        .fillMaxWidth()

                    if (!expanded) {
                        rowModifier = rowModifier.height(150.dp)
                    }

                    Row(
                        modifier = rowModifier
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(5.dp, 24.dp, 5.dp, 12.dp)
                        ) {
                            Text(
                                text = book.summary,
                                modifier = Modifier
                                    .clickable {
                                        Log.d("Text_Field", "Text field clicked")
                                        //TODO : expand and contract text summary area
                                    },
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
        Box {
            Column {
                if (book.notes != null) {
                    Row(
                        modifier = Modifier
                            .padding(5.dp)
                            .defaultMinSize(minHeight = 150.dp)
                    ) {
                        Column {
                            Text(text = "Notes", style = MaterialTheme.typography.labelMedium)
                            Text(text = book.notes, style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = {
                            /*TODO:  navigate to edit screen*/
                        }
                    ) {
                        Icon(
                            Icons.Default.Edit, contentDescription = "Edit",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun BookDetailsPreview() {
    BookDetails()
}