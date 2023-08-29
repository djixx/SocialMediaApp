package com.example.myapp.service.implementation;

import com.example.myapp.model.Post;
import com.example.myapp.repo.PostRepo;
import com.example.myapp.service.PostService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    @Override
    public Post create(Post post) {
        return postRepo.save(post);
    }

    @Override
    public Post get(Long id) {
        return postRepo.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        Post post = get(id);
        postRepo.delete(post);
    }

    @Override
    public List<Post> returnPost() {
        return postRepo.findAllByOrderByPostIdDesc();
    }
}


