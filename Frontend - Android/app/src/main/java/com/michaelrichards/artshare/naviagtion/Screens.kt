package com.michaelrichards.artshare.naviagtion

sealed class Screens(
    val routeName: String
) {
    data object RegistrationScreen: Screens("registration-screen")
    data object LoginScreen: Screens("login-screen")
    data object HomeScreen : Screens("home-screen")
    data object SplashScreen : Screens("splash-screen")
    data object ProfileScreen: Screens("profile-screen")
}