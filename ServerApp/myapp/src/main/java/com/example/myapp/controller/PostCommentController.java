package com.example.myapp.controller;

import com.example.myapp.converter.PostCommentConverter;
import com.example.myapp.dtos.PostCommentDto;
import com.example.myapp.model.PostComment;
import com.example.myapp.service.PostCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class PostCommentController {
    private final PostCommentService postCommentService;
    private final PostCommentConverter postCommentConverter;

    @GetMapping("/get/{postId}")
    public ResponseEntity<List<PostCommentDto>> getCommentById(@PathVariable Long postId) {
        List<PostComment> posts = postCommentService.getByPostId(postId);
        return ResponseEntity.ok(postCommentConverter.convertList(posts));
    }

    @PostMapping("/save")
    public ResponseEntity<PostCommentDto> saveComment(@RequestBody PostCommentDto postCommentDto) {
        PostComment postComment = postCommentService.save(postCommentDto);
        return ResponseEntity.ok(postCommentConverter.convert(postComment));
    }
}
