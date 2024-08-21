package com.example.simplequotesapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.simplequotesapp.models.Quotes

@Composable
fun QuoteListScreen(data: Array<Quotes>, onClick: (quotes: Quotes) -> Unit) {
    Column {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp, 24.dp)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.h5,
        )
        QuoteList(data = data, onClick = onClick)
    }
}
