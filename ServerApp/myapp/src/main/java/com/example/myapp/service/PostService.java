package com.example.myapp.service;

import com.example.myapp.model.Post;

import java.util.Collection;
import java.util.List;

public interface PostService {
    Post create(Post post);

    Post get(Long id);

    void delete(Long id);

    List<Post> returnPost();

}
