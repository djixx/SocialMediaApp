package com.example.myapp.dtos;

import com.example.myapp.enumeration.Gender;
import com.example.myapp.enumeration.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * Data Transfer Object (DTO) class that represents user information to be transferred between the database and the client side.
 * This class encapsulates various user-related fields for efficient data communication.
 */
@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDate dateOfBirth;
    private String password;
    /**
     * The URL to the user's profile image.
     */
    private String imageUrl;
    private Gender gender;
    /**
     * A list of PostDto objects representing posts created by the user.
     */
    private List<PostDto> posts;
    /**
     * The role of the user in the application (e.g., user, admin).
     */
    private Role role;
}
