package com.example.simplequotesapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.simplequotesapp.DataManager
import com.example.simplequotesapp.models.Quotes

@Composable
fun QuoteDetail(quotes: Quotes) {
    BackHandler {
        DataManager.switchPage(null)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3)
                    )
                )
            )
    ) {
        Card(
            elevation = 4.dp,
            modifier = Modifier.padding(32.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp, 24.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Quote",
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180f)
                )
                Text(
                    text = quotes.text,
                    style = MaterialTheme.typography.h6
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = quotes.author,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}
