package com.michaelrichards.artshare.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SplashComposable(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column {
            Text("Art", style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.Bold))
            Text("Share", style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.Bold))
        }

    }
}

@Preview
@Composable
private fun SplashPreview() {
    SplashComposable()
}