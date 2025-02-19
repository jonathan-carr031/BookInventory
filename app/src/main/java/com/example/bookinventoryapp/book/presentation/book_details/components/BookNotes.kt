package com.example.bookinventoryapp.book.presentation.book_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BookNotes(
    bookNotes: String
) {
    HorizontalDivider(thickness = 2.dp)
    Row(
        modifier = Modifier
            .padding(5.dp, 6.dp, 5.dp, 6.dp)
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
                    text = bookNotes,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview
@Composable
fun BookNotesPreview() {
    BookNotes("These are the notes for my book")
}