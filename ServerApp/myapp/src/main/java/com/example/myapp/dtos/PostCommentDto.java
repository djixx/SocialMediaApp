package com.example.myapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCommentDto {

    private long commentId;
    private long postId;
    private String text;
    private String username;
}
