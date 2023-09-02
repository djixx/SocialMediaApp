package com.example.myapp.repo;

import com.example.myapp.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostCommentRepo extends JpaRepository<PostComment, Long> {
    List<PostComment> getByPostId(Long postId);
}
