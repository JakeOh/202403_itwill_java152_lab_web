package com.itwill.spring2.dto;

import lombok.Data;

@Data
// 검색 요청에서의 요청 파라미터 검색 카테고리와 검색어를 저장하기 위한 DTO
public class PostSearchDto {
    private String category;
    private String keyword;
}
