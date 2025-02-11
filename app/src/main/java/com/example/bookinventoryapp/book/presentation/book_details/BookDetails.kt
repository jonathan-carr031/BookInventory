package com.example.bookinventoryapp.book.presentation.book_details

import android.graphics.BitmapFactory
import android.net.Uri
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.bookinventoryapp.book.domain.Book
import com.example.bookinventoryapp.ui.components.AppFloatingActionButton
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun BookDetails() {
    val book = Book(
        "NRWPDQAAQBAJ",
        "Chocolate War",
        "123456789",
        authors = listOf(
            "Robert Cormier",
            "Bryan Adams",
            "Bryan Adams",
            "Bryan Adams",
            "Bryan Adams"
        ),
        summary = "One of the most controversial YA novels of all time, The Chocolate War is a modern masterpiece that speaks to fans of S. E. Hinton’s The Outsiders and John Knowles’s A Separate Peace. After suffering rejection from seven major publishers, The Chocolate War made its debut in 1974, and quickly became a bestselling—and provocative—classic for young adults. This chilling portrait of an all-boys prep school casts an unflinching eye on the pitfalls of conformity and corruption in our most elite cultural institutions. “Masterfully structured and rich in theme; the action is well crafted, well timed, suspenseful.”—The New York Times Book Review “The characterizations of all the boys are superb.”—School Library Journal, starred review “Compellingly immediate. . . . Readers will respect the uncompromising ending.”—Kirkus Reviews, starred review An ALA Best Book for Young Adults A School Library Journal Best Book of the Year A Kirkus Reviews Editor’s Choice A New York Times Outstanding Book of the Year",
        coverByteArray = byteArrayOf(),
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

    val expanded = remember {
        mutableStateOf(false)
    }

    val isEditing = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(6.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(2f),
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = book.title, style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(3.dp))
                    Text(
                        modifier = Modifier
                            .wrapContentWidth(
                                align = Alignment.Start
                            ),
                        text = book.authors.joinToString(", "),
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(Modifier.height(6.dp))
                    val publishedDateString =
                        book.publishedDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))
                    Text(
                        text = "Published $publishedDateString",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxSize()
                    .weight(1f),
                contentAlignment = Alignment.TopEnd,
            ) {
                val bitmapImage =
                    BitmapFactory.decodeByteArray(book.coverByteArray, 0, book.coverByteArray.size)
                Image(
                    painter = painterResource(R.drawable.chocolate_war_cover),
//                    bitmap = bitmapImage.asImageBitmap(),
                    contentDescription = book.title,
                    modifier = Modifier
                        .aspectRatio(.66f)
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
        Spacer(Modifier.height(6.dp))
        HorizontalDivider(thickness = 2.dp)
        Spacer(Modifier.height(3.dp))
        if (book.summary != null) {
            var rowModifier = Modifier
                .fillMaxWidth()
                .animateContentSize()

            if (!expanded.value) {
                rowModifier = rowModifier.height(150.dp)
            }

            Spacer(Modifier.height(6.dp))
            Row(
                modifier = rowModifier
            ) {
                Box(
                    modifier = Modifier
                        .padding(5.dp)
                ) {
                    Text(
                        text = book.summary,
                        modifier = Modifier
                            .clickable {
                                expanded.value = !expanded.value
                            },
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            if (expanded.value) {
                Icon(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.CenterHorizontally)
                        .clickable {
                            expanded.value = !expanded.value
                        },
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "Collapse",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            } else {
                Icon(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.CenterHorizontally)
                        .clickable {
                            expanded.value = !expanded.value
                        },
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Expand",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }


        }
        if (book.notes != null) {
            Spacer(Modifier.height(3.dp))
            HorizontalDivider(thickness = 2.dp)
            Spacer(Modifier.height(3.dp))
            Row(
                modifier = Modifier
                    .padding(5.dp)
                    .defaultMinSize(minHeight = 150.dp)
            ) {
                Column {
                    Text(
                        modifier = Modifier.padding(horizontal = 5.dp),
                        text = "Notes",
                        style = MaterialTheme.typography.labelMedium
                    )
                    Spacer(Modifier.height(6.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(6.dp))
                            .background(color = MaterialTheme.colorScheme.primaryContainer)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(6.dp)
                                .clip(shape = RoundedCornerShape(6.dp)),
                            text = book.notes,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
    AppFloatingActionButton(
        imageVector = Icons.Default.Edit,
        contentDescription = "Edit",
        onClickAction = { /*TODO navigate to edit details page*/ },
    )
}


@Preview
@Composable
fun BookDetailsPreview() {
    BookDetails()
}