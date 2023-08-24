package com.example.myapp.converter;

import com.example.myapp.dtos.PostDto;
import com.example.myapp.model.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PostConverter {
    public PostDto convert(Post post) {
        PostDto postDto = new PostDto();
        postDto.setPostId(post.getPostId());
        postDto.setText(post.getText());
        postDto.setTitle(post.getTitle());
        postDto.setUserId(post.getUser().getUserId());
        postDto.setAuthor(post.getUser().getFirstname() + ' ' + post.getUser().getLastName());
        return postDto;
    }

    public List<PostDto> convertList(List<Post> posts) {
        List<PostDto> list = new ArrayList<>();
        for (Post post : posts) {
            PostDto postDto = convert(post);
            list.add(postDto);
        }
        return list;
    }
}
