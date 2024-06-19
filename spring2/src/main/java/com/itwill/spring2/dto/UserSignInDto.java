package com.itwill.spring2.dto;

import com.itwill.spring2.repository.User;

import lombok.Data;

@Data
public class UserSignInDto {
    private String userid;
    private String password;
    
    public User toEntity() {
        return User.builder()
                .userid(userid)
                .password(password)
                .build();
    }
}
