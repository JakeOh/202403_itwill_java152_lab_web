package com.itwill.spring2.dto;

import com.itwill.spring2.repository.Post;

import lombok.Data;

@Data
// 새 글 작성 요청에서 요청 파라미터들을 저장하기 위한 DTO
public class PostCreateDto {
    // 필드 이름을 요청 파라미터 이름과 같게 선언 & 기본 생성자 & setter.
    private String title;
    private String content;
    private String author;

    public Post toEntity() {
        return Post.builder().title(title).content(content).author(author).build();
    }
    
}
