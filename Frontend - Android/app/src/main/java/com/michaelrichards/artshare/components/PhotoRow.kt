package com.michaelrichards.artshare.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.michaelrichards.artshare.dto.PhotoItem

@Composable
fun PhotoRow(modifier: Modifier = Modifier, photos: List<PhotoItem>) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Ensure we always have 3 items in the row (fill with empty if needed)
        for (i in 0 until 3) {
            if (i < photos.size) {
                PhotoCard(photo = photos[i], modifier = Modifier.weight(1f)){

                }
            } else {
                // Empty space to maintain grid alignment
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}
