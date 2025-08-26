package com.michaelrichards.artshare.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class UserProfileResponse {
    private Long id;
    private String username;
    private String email;
    private LocalDate birthday;
    private Integer age; // Calculated on the fly from birthday
    private String bio;
    private String avatarUrl;
    private LocalDateTime createdAt;

    // Often, you only send counts or summaries, not full entities to avoid huge responses
   /* private int artworkCount;
    private int followerCount;
    private int followingCount;*/

}
