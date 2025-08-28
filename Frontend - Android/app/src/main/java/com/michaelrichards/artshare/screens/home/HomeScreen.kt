package com.michaelrichards.artshare.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.michaelrichards.artshare.components.ArtBottomNavigationBar

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(
        bottomBar = { ArtBottomNavigationBar(navController) }
    ) { paddingValues ->

        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)){
            Text("Home Screen", style = MaterialTheme.typography.displayLarge)
        }
    }
}