package com.michaelrichards.artshare.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CreateUserRequest {

    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Username is mandatory")
    @Size(min = 1, max = 20, message = "First name must be between 1 and 20 characters")
    private String firstName;

    @NotBlank(message = "Username is mandatory")
    @Size(min = 1, max = 20, message = "Last name must be between 1 and 20 characters")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Size(max = 50)
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, max = 40, message = "Password must be between 6 and 40 characters")
    private String password;

    @Past(message = "Birthday must be a date in the past")
    private LocalDate birthday;

    @Size(max = 500, message = "Bio cannot exceed 500 characters")
    private String bio;
}
