package com.example.myapp.controller;

import com.example.myapp.converter.UserConverter;
import com.example.myapp.dtos.UserDto;
import com.example.myapp.model.Post;
import com.example.myapp.model.User;
import com.example.myapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/users") //mzd ovdje
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final UserService userService; //dependancy injection
    private final UserConverter userConverter;

    @GetMapping("/get")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = userService.returnUsersSorted();
        return ResponseEntity.ok(userConverter.convertList(users));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getOneUser(@PathVariable("id") Long id) {
        User user = userService.get(id);
        List<Post>  userPosts = user.getPosts();
        UserDto userDto = userConverter.convert(user);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserDto userDto) {
        User user = new User();
        setUserInfo(userDto, user);
        userService.create(user);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody @Valid UserDto userDto) {
        User user = userService.get(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        setUserInfo(userDto, user);
        userService.update(user);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<UserDto>> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        List<User> users = userService.returnUsers();
        return ResponseEntity.ok(userConverter.convertList(users));
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<List<UserDto>>  deleteAll() {
        userService.delete();
        List<User> users = userService.returnUsers();
        return ResponseEntity.ok(userConverter.convertList(users));
    }

    //Menas that we are returning bytes for image
    @GetMapping(path = "/image/{fileName}", produces = IMAGE_PNG_VALUE)
    public byte[] getImage(@PathVariable("fileName") String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/Desktop/Projekat_Web/my_project/slike/" + fileName));
    }

    private static void setUserInfo(UserDto userDto, User user) {
        user.setUsername(userDto.getUsername());
        user.setFirstname(userDto.getFirstname());
        user.setLastName(userDto.getLastname());
        user.setPassword(userDto.getPassword());
        user.setDate(userDto.getDateOfBirth());
        user.setEmail(userDto.getEmail());
        user.setImageUrl(userDto.getImageUrl());
        user.setGender(userDto.getGender());
        //mogu ovdje i postove updatovati
    }
}
