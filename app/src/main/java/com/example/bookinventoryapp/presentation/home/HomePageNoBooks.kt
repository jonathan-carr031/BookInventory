package com.example.bookinventoryapp.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomePageNoBooks(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(text = "You have no books", Modifier.padding(vertical = 4.dp))
        Button(
            shape = RoundedCornerShape(12),
            onClick = {/*TODO: navigate to add book page*/ }
        ) {
            Text(text = "Add a Book")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePageNoBooksPreview() {
    HomePageNoBooks()
}