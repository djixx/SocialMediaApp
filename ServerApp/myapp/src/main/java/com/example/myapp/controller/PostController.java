package com.example.myapp.controller;

import com.example.myapp.converter.PostConverter;
import com.example.myapp.dtos.PostDto;
import com.example.myapp.model.Post;
import com.example.myapp.model.User;
import com.example.myapp.service.PostService;
import com.example.myapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts") //mzd ovdje
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {

    private final PostService postService;
    private final UserService userService;
    private final PostConverter postConverter;

    @PostMapping("/save")
    public ResponseEntity<PostDto> save(@RequestBody @Valid PostDto postDto) {
        Post post = new Post();
        post.setText(postDto.getText());
        User user = userService.get(postDto.getUserId());
        post.setUser(user);
        post = postService.create(post);
        return ResponseEntity.ok(postConverter.convert(post));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PostDto>> getAll() {
        List<Post> posts = postService.returnPost();
        return ResponseEntity.ok(postConverter.convertList(posts));
    }


    @GetMapping("/getOne/{userId}")
    public ResponseEntity<List<PostDto>> getPosts(@PathVariable Long userId) {
        User user = userService.get(userId);
        List<Post> posts = user.getPosts();
        return ResponseEntity.ok(postConverter.convertList(posts));
    }


}
