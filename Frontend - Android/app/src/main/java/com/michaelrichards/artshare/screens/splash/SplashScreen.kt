package com.michaelrichards.artshare.screens.splash

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.michaelrichards.artshare.naviagtion.Graphs

@Composable
fun SplashScreen(modifier: Modifier = Modifier, navController: NavController) {

    //todo: make a real splash screen after login is finished



    SplashComposable(modifier = modifier){
        navController.navigate(Graphs.MainGraph.graphName){
            popUpTo(Graphs.SplashGraph.graphName){
                inclusive = true
            }
        }
    }
}