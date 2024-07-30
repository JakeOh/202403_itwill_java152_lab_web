package com.itwill.springboot5.dto;

import lombok.Data;

@Data
public class PostUpdateDto {
    private Long id;
    private String title;
    private String content;
}
