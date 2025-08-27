package com.michaelrichards.artshare.screens.profile


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.KeyboardArrowDown
import androidx.compose.material.icons.twotone.Lock
import androidx.compose.material.icons.twotone.LockOpen
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.michaelrichards.artshare.R
import com.michaelrichards.artshare.dto.UserResponse
import java.time.LocalDate
import java.time.Period
import java.util.UUID

@Composable
fun ProfileComposable(modifier: Modifier = Modifier, userResponse: UserResponse) {
    Scaffold(
        topBar = {
            Row(
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Row(
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
        modifier = modifier.padding(8.dp)
    ) { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues).fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                AsyncImage(
                    modifier = Modifier
                        .size(75.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray, CircleShape),
                    model = userResponse.avatarUrl,
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.fillMaxWidth()) {
                    Row {
                        Text(userResponse.firstName, style = MaterialTheme.typography.headlineSmall)
                        Spacer(Modifier.width(4.dp))
                        Text(userResponse.lastName, style = MaterialTheme.typography.headlineSmall)
                    }

                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(stringResource(R.string.posts), style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold))
                            Text("${userResponse.artworkCount}")
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(stringResource(R.string.followers), style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold))
                            Text("${userResponse.followerCount}")
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(stringResource(R.string.following), style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold))
                            Text("${userResponse.followingCount}")
                        }
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                    Text(stringResource(R.string.edit_profile))
                }
            }
            Text(userResponse.bio)
        }
    }
}

@Preview
@Composable
private fun PreviewProfile() {


    ProfileComposable(userResponse = mockUserResponse)
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