package com.example.myapp.repo;

import com.example.myapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepo extends JpaRepository<Post, Long> {

    Optional<Post> findById(Long id);

    List<Post> findAll();

}
