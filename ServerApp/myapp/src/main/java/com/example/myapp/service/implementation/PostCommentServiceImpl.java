package com.example.myapp.service.implementation;

import com.example.myapp.dtos.PostCommentDto;
import com.example.myapp.model.Post;
import com.example.myapp.model.PostComment;
import com.example.myapp.repo.PostCommentRepo;
import com.example.myapp.service.PostCommentService;
import com.example.myapp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostCommentServiceImpl implements PostCommentService {
    private final PostService postService;

    private final PostCommentRepo postCommentRepo;

    @Override
    public PostComment get(Long id) {
        return null;
    }

    @Override
    public List<PostComment> getByPostId(Long postId) {
        return postCommentRepo.getByPostId(postId);
    }

    @Override
    public PostComment save(PostCommentDto postCommentDto) {
        Post post = postService.get(postCommentDto.getPostId());
        PostComment postComment = new PostComment();
        postComment.setPost(post);
        postComment.setText(postCommentDto.getText());
        postComment.setUsername(postCommentDto.getUsername());
        return postCommentRepo.save(postComment);
    }
}
