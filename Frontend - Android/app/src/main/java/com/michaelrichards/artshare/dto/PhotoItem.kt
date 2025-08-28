package com.michaelrichards.artshare.dto

data class PhotoItem(
    val id: String,
    val imageUrl: String,
    val caption: String,
    val user: String,
    val likes: Int = 0
)


val samplePhotos = listOf(
    PhotoItem("1", "https://picsum.photos/400/600?random=1", "Sunset Dreams", "Artist One", 124),
    PhotoItem("2", "https://picsum.photos/400/600?random=2", "Mountain Majesty", "Artist Two", 89),
    PhotoItem("3", "https://picsum.photos/400/600?random=3", "Ocean Waves", "Artist Three", 156),
    PhotoItem("4", "https://picsum.photos/400/600?random=4", "Urban Jungle", "Artist Four", 67),
    PhotoItem("5", "https://picsum.photos/400/600?random=5", "Forest Path", "Artist Five", 203),
    PhotoItem("6", "https://picsum.photos/400/600?random=6", "Desert Sands", "Artist Six", 98),
    PhotoItem("7", "https://picsum.photos/400/600?random=7", "Winter Wonderland", "Artist Seven", 145),
    PhotoItem("8", "https://picsum.photos/400/600?random=8", "Spring Blossoms", "Artist Eight", 112),
    PhotoItem("9", "https://picsum.photos/400/600?random=9", "Summer Vibes", "Artist Nine", 87),
    PhotoItem("10", "https://picsum.photos/400/600?random=10", "Autumn Colors", "Artist Ten", 176),
    PhotoItem("11", "https://picsum.photos/400/600?random=11", "City Lights", "Artist Eleven", 134),
    PhotoItem("12", "https://picsum.photos/400/600?random=12", "Night Sky", "Artist Twelve", 201)
)