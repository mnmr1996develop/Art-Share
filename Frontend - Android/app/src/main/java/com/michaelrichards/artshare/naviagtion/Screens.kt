package com.michaelrichards.artshare.naviagtion

sealed class Screens(
    val routeName: String
) {
    //splash graph
    data object SplashScreen : Screens("splash-screen")

    //auth graph
    data object RegistrationScreen: Screens("registration-screen")
    data object LoginScreen: Screens("login-screen")

    //main graph
    data object HomeScreen : Screens("home-screen")
    data object SearchScreen: Screens("search-screen")
    data object CreateScreen: Screens("camera-screen")
    data object ProfileScreen: Screens("profile-screen")
    data object FollowScreen: Screens("follow-screen")
}