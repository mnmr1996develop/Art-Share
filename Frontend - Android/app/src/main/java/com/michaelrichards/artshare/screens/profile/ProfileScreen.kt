package com.michaelrichards.artshare.screens.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ProfileScreen(modifier: Modifier = Modifier, navController: NavController) {



    ProfileComposable(
        modifier = modifier,
        userResponse = mockUserResponse,
        onUsernameClick = {  },
        onProfileImageClick = {},
        onPostsClick = {},
        onFollowersClick = {},
        onFollowingClick = {},
        onEditProfileCLick = {}
    )
}