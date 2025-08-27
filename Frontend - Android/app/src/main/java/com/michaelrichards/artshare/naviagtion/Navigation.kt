package com.michaelrichards.artshare.naviagtion

import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.michaelrichards.artshare.screens.profile.ProfileScreen
import com.michaelrichards.artshare.screens.splash.SplashScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Graphs.SplashGraph.graphName) {

        navigation(
            route = Graphs.SplashGraph.graphName,
            startDestination = Screens.SplashScreen.routeName
        ) {
            composable(route = Screens.SplashScreen.routeName) {
                SplashScreen(modifier = modifier, navController = navController)
            }

        }

        navigation(
            route = Graphs.MainGraph.graphName,
            startDestination = Screens.ProfileScreen.routeName
        ) {
            composable(route = Screens.ProfileScreen.routeName){
                ProfileScreen(navController = navController, modifier = modifier)
            }

        }
    }

}