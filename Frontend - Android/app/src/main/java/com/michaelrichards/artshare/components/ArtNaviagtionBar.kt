package com.michaelrichards.artshare.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.michaelrichards.artshare.naviagtion.Screens

@Composable
fun ArtBottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        modifier = Modifier.height(70.dp),
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 8.dp
    ) {
        tabItems.forEach { item ->
            val isSelected = currentRoute == item.screen.routeName

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(item.screen.routeName) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    if (item.screen.routeName == Screens.CreateScreen.routeName) {
                        // Special styling for the Create button
                        CreateButton(isSelected = isSelected)
                    } else {
                        Icon(
                            imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                            contentDescription = item.title,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                label = {
                    if (item.screen.routeName != Screens.CreateScreen.routeName) {
                        Text(
                            text = item.title,
                            fontSize = 12.sp
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
                )
            )
        }
    }
}

private val tabItems: List<TabItem> = listOf(
    TabItem(
        title = "Home",
        unselectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home,
        screen = Screens.HomeScreen
    ),
    TabItem(
        title = "Search",
        unselectedIcon = Icons.Outlined.Search,
        selectedIcon = Icons.Filled.Search,
        screen = Screens.SearchScreen
    ),
    TabItem(
        title = "Create",
        unselectedIcon = Icons.Outlined.AddCircle,
        selectedIcon = Icons.Filled.AddCircle,
        screen = Screens.CreateScreen
    ),
    TabItem(
        title = "Follow",
        unselectedIcon = Icons.Outlined.Groups,
        selectedIcon = Icons.Filled.Groups,
        screen = Screens.FollowScreen
    ),
    TabItem(
        title = "Profile",
        unselectedIcon = Icons.Outlined.AccountCircle,
        selectedIcon = Icons.Filled.AccountCircle,
        screen = Screens.ProfileScreen
    )
)

private data class TabItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val screen: Screens
)