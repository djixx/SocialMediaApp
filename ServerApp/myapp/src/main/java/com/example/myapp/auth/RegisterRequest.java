package com.example.myapp.auth;

import com.example.myapp.enumeration.Gender;
import com.example.myapp.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String imageUrl;
    private Role role;
}
