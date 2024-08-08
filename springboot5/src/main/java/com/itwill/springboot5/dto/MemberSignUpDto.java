package com.itwill.springboot5.dto;

import com.itwill.springboot5.domain.Member;

import lombok.Data;

@Data
public class MemberSignUpDto {
    private String username;
    private String password;
    private String email;
    
    public Member toEntity() {
        return Member.builder()
                .username(username).password(password).email(email)
                .build();
    }
}
