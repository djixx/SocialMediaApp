package com.example.myapp.auth;

//This authentication controller will have two endpoints that
//will allow me to create or register new account and authenticate an exiting user

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    /**
     * Controller method for handling user registration through a POST request.
     *
     * @param request The user registration details provided in the request body.
     * @return ResponseEntity containing an AuthenticationResponse indicating the outcome of the registration process.
     */
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    /**
     * Controller method for handling user login through a POST request.
     *
     * @param request The user authentication details provided in the request body.
     * @return ResponseEntity containing an AuthenticationResponse indicating the outcome of the authentication process.
     */
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
