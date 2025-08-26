package com.michaelrichards.artshare.controller;

import com.michaelrichards.artshare.dto.CreateUserRequest;
import com.michaelrichards.artshare.dto.UserProfileResponse;
import com.michaelrichards.artshare.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<UserProfileResponse>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserProfileResponse> postUser(@RequestBody CreateUserRequest userRequest){
        return ResponseEntity.ok(userService.addUser(userRequest));
    }
}
