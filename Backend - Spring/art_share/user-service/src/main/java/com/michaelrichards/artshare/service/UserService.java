package com.michaelrichards.artshare.service;

import com.michaelrichards.artshare.dto.CreateUserRequest;
import com.michaelrichards.artshare.dto.UserProfileResponse;
import com.michaelrichards.artshare.repository.UserRepository;
import com.michaelrichards.artshare.user.User;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserProfileResponse> getAllUsers() {
        return userRepository.findAll().stream().map(
                this::mapUserToUserProfileResponse
        ).toList();
    }

    private UserProfileResponse mapUserToUserProfileResponse(User user) {
        return UserProfileResponse.builder()
                .email(user.getEmail())
                .avatarUrl(user.getAvatarUrl())
                .birthday(user.getBirthday())
                .id(user.getId())
                .createdAt(user.getCreatedAt())
                .age(user.getAge())
                .bio(user.getBio())
                .build();
    }

    public UserProfileResponse addUser(CreateUserRequest userRequest) {
        var user = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .username(userRequest.getUsername())
                .bio(userRequest.getBio())
                .birthday(userRequest.getBirthday())
                .email(userRequest.getEmail())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        User savedUser = userRepository.save(user);

        return mapUserToUserProfileResponse(savedUser);
    }
}
