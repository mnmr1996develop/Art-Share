package com.michaelrichards.artshare.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.michaelrichards.artshare.naviagtion.Graphs
import com.michaelrichards.artshare.naviagtion.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier: Modifier = Modifier, navController: NavController) {

    //todo: make a real splash screen after login is finished

    LaunchedEffect(Unit) {
        delay(8000)
        navController.navigate(
            Graphs.MainGraph.graphName
        ){
            popUpTo(Graphs.SplashGraph.graphName){
                inclusive = true
            }
        }

    }

    SplashComposable(modifier = modifier)
}