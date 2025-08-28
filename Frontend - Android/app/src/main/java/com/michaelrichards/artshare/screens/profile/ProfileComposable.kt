package com.michaelrichards.artshare.screens.profile


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.KeyboardArrowDown
import androidx.compose.material.icons.twotone.Lock
import androidx.compose.material.icons.twotone.LockOpen
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.michaelrichards.artshare.R
import com.michaelrichards.artshare.components.ArtBottomNavigationBar
import com.michaelrichards.artshare.components.PhotoGrid
import com.michaelrichards.artshare.components.UserProfileColumn
import com.michaelrichards.artshare.dto.PhotoItem
import com.michaelrichards.artshare.dto.UserResponse
import com.michaelrichards.artshare.dto.samplePhotos
import kotlinx.coroutines.delay
import java.time.LocalDate
import java.time.Period
import java.util.UUID

@Composable
fun ProfileComposable(
    modifier: Modifier = Modifier,
    userResponse: UserResponse,
    navController: NavController,
    onUsernameClick: () -> Unit,
    onProfileImageClick: () -> Unit,
    onPostsClick: () -> Unit,
    onFollowersClick: () -> Unit,
    onFollowingClick: () -> Unit,
    onEditProfileCLick: () -> Unit
) {

    var photos by remember { mutableStateOf<List<PhotoItem>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(1000) // Simulate network delay
        photos = samplePhotos
        isLoading = false
    }


    Scaffold(
        topBar = {
            Row(
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Row(
                    modifier = Modifier.clickable(onClick = onUsernameClick),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(

                        imageVector = if (userResponse.isPrivate) Icons.TwoTone.Lock else Icons.TwoTone.LockOpen,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        userResponse.username,
                        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
                    )
                    Icon(imageVector = Icons.TwoTone.KeyboardArrowDown, contentDescription = null)
                }
            }
        },
        bottomBar = {
            ArtBottomNavigationBar(navController)
        },
        modifier = modifier.padding(8.dp)
    ) { paddingValues ->

        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()) {


            UserProfileColumn(
                avatarUrl = userResponse.avatarUrl,
                firstName = userResponse.firstName,
                lastName = userResponse.lastName,
                artworkCount = userResponse.artworkCount,
                followerCount = userResponse.followerCount,
                followingCount = userResponse.followingCount,
                onPostsClick = onPostsClick,
                onFollowingClick = onFollowingClick,
                onFollowersClick = onFollowersClick,
                onProfileImageClick = onProfileImageClick,
            )

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = onEditProfileCLick, modifier = Modifier.fillMaxWidth()) {
                    Text(stringResource(R.string.edit_profile))
                }
            }
            Text(userResponse.bio)


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF5F5F5))
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                } else {
                    PhotoGrid(photos = photos)
                }
            }
        }


    }
}

@Preview
@Composable
private fun PreviewProfile() {

    val navController = NavController(LocalContext.current)

    ProfileComposable(
        userResponse = mockUserResponse,
        modifier = Modifier,
        onUsernameClick = { },
        onProfileImageClick = {},
        onPostsClick = {},
        onFollowersClick = {},
        onFollowingClick = {},
        onEditProfileCLick = {},
        navController = navController
    )
}


val mockUserResponse = UserResponse(
    firstName = "max",
    id = UUID.randomUUID(),
    username = "maximillion",
    lastName = "Richardson",
    email = "mnmr1996@gmail.com",
    birthday = LocalDate.of(1996, 11, 11),
    age = Period.between(LocalDate.of(1996, 11, 11), LocalDate.now()).years,
    bio = "Hi This is max's bio",
    avatarUrl = "https://static.wikia.nocookie.net/p__/images/5/52/AangTransparent.png/revision/latest/scale-to-width-down/1200?cb=20241019060928&path-prefix=protagonist",
    createdAt = LocalDate.now().minusYears(15).toString(),
    isPrivate = false,
    followingCount = 400,
    followerCount = 369,
    artworkCount = 89
)