package com.example.myapp.converter;

import com.example.myapp.dtos.PostCommentDto;
import com.example.myapp.model.PostComment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostCommentConverter {
    public List<PostCommentDto> convertList(List<PostComment> comments) {

        List<PostCommentDto> list = new ArrayList<>();
        for (PostComment comment : comments) {
            PostCommentDto postCommentDto = convert(comment);
            list.add(postCommentDto);
        }
        return list;
    }

    public PostCommentDto convert(PostComment comment) {
        PostCommentDto dto = new PostCommentDto();
        dto.setCommentId(comment.getCommentId());
        dto.setPostId(comment.getPost().getPostId());
        dto.setText(comment.getText());
        dto.setUsername(comment.getUsername());

        return dto;
    }
}
