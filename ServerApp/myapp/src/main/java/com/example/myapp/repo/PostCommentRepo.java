package com.example.myapp.repo;

import com.example.myapp.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostCommentRepo extends JpaRepository<PostComment, Long> {

    @Query("from PostComment pc where pc.post.postId = :postId")
    List<PostComment> getByPostId(Long postId);

    //getByPostId
}
