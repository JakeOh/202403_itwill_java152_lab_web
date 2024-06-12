package com.itwill.spring2.dto;

import com.itwill.spring2.repository.Post;

import lombok.Data;

@Data
// 업데이트 요청의 요청 파라미터들을 저장하기 위한 DTO
public class PostUpdateDto {
    private int id;
    private String title;
    private String content;
    
    public Post toEntity() {
        return Post.builder().id(id).title(title).content(content).build();
    }
}
