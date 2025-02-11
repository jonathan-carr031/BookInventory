package com.example.bookinventoryapp.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppFloatingActionButton(
    imageVector: ImageVector,
    contentDescription: String,
    onClickAction: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        FloatingActionButton(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomEnd),
            onClick = onClickAction,
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ) {
            Icon(
                imageVector, contentDescription = contentDescription,
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Preview
@Composable
fun AppFloatingActionButtonPreview() {
    AppFloatingActionButton(
        imageVector = Icons.Default.PlayArrow,
        contentDescription = "Floating Action Button",
        onClickAction = {
            Log.d("Floating_Action", "Floating Action Clicked")
        }
    )
}