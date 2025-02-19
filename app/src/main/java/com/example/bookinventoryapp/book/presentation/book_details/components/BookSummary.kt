package com.example.bookinventoryapp.book.presentation.book_details.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BookSummary(
    bookSummary: String
) {
    var hasOverFlowed by remember {
        mutableStateOf(false)
    }

    val expanded = remember {
        mutableStateOf(false)
    }

    var rowModifier = Modifier
        .fillMaxWidth()
        .animateContentSize()

    var textModifier = Modifier.fillMaxWidth()

    if (hasOverFlowed || expanded.value) {
        textModifier = textModifier
            .clickable {
                expanded.value = !expanded.value
            }
    }

    if (!expanded.value) {
        rowModifier = rowModifier.heightIn(max = 100.dp)
    }

    HorizontalDivider(thickness = 2.dp)

    Column(
        modifier = Modifier.padding(top = 6.dp, bottom = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .heightIn(max = 300.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = rowModifier
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                    ) {
                        Text(
                            text = bookSummary,
                            modifier = textModifier,
                            overflow = TextOverflow.Ellipsis,
                            onTextLayout = { textLayoutResult ->
                                hasOverFlowed = textLayoutResult.hasVisualOverflow
                            }
                        )
                    }
                }
            }
        }

        if (hasOverFlowed || expanded.value) {
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
    }
}

@Preview
@Composable
fun BookSummaryPreview() {
    Column {
        BookSummary("This is the summary of the book that was selected.")
        BookSummary("This is the summary of the book that was selected. This is the summary of the book that was selected. This is the summary of the book that was selected. This is the summary of the book that was selected.This is the summary of the book that was selected.This is the summary of the book that was selected.This is the summary of the book that was selected.")
    }
}