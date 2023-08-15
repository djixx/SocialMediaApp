package com.example.myapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    private Long postId;
    private String text;
    private Long userId;
}
