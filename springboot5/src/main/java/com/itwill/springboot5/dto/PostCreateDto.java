package com.itwill.springboot5.dto;

import com.itwill.springboot5.domain.Post;

import lombok.Data;

@Data
public class PostCreateDto {
    private String title;
    private String content;
    private String author;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
