package com.example.myapp.service;

import com.example.myapp.dtos.PostCommentDto;
import com.example.myapp.model.PostComment;

import java.util.List;

public interface PostCommentService {

    PostComment get(Long id);

    List<PostComment> getByPostId(Long postId);

    PostComment save(PostCommentDto postCommentDto);
}
