package com.example.bookinventoryapp.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ErrorMessage(
    message: String
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = message,
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.85f),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun ErrorMessagePreview() {
    ErrorMessage("ERROR HAPPENED")
}