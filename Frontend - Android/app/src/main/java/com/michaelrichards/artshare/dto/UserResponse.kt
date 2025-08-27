package com.michaelrichards.artshare.dto

import java.time.LocalDate
import java.util.UUID

data class UserResponse(
    val id: UUID,
    val username: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val birthday: LocalDate,
    val age: Int, // Calculated on the fly from birthday
    val bio : String,
    val avatarUrl: String,
    val createdAt: String,
    val isPrivate: Boolean = true,
    val artworkCount: Int,
    val followerCount: Int,
    val followingCount: Int

)
