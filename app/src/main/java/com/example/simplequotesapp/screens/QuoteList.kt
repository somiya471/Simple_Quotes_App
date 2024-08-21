package com.example.simplequotesapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.simplequotesapp.models.Quotes

@Composable
fun QuoteList(data: Array<Quotes>, onClick: (quotes: Quotes) -> Unit) {
    LazyColumn(content = {
        items(data) { quote ->
            QuoteListItem(quotes = quote, onClick = onClick)
        }
    })
}
