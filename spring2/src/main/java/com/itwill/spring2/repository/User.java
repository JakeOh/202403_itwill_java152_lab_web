package com.itwill.spring2.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 데이터베이스 테이블 users 테이블의 모델 객체
@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    private Integer id; // PK
    private String userid; // 로그인 아이디
    private String password; // 로그인 비밀번호
    private String email; // 이메일
    private Integer points; // 포인트
}
