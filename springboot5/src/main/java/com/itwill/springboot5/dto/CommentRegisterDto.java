package com.itwill.springboot5.dto;

import com.itwill.springboot5.domain.Comment;

import lombok.Data;

@Data
public class CommentRegisterDto {
    private Long postId;
    private String ctext;
    private String writer;
}
