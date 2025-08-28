package com.michaelrichards.artshare.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.michaelrichards.artshare.dto.PhotoItem
import androidx.compose.foundation.lazy.items

@Composable
fun PhotoGrid(modifier: Modifier = Modifier, photos: List<PhotoItem>) {

    val rows = photos.chunked(3)

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(rows) { rowPhotos ->
            PhotoRow(photos = rowPhotos)
        }
    }
}