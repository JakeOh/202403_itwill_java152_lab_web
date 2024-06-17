package com.itwill.spring2.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.itwill.spring2.repository.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class CommentItemDto {
    private Integer id;
    private String ctext;
    private String username;
    private Timestamp modifiedTime; // JS에서 시간/날짜 타입을 표현하기 위해서.

    // Comment 타입의 객체를 CommentItemDto 타입 객체로 변환해서 리턴하는 메서드.
    public static CommentItemDto fromEntity(Comment comment) {
        return CommentItemDto.builder()
                .id(comment.getId())
                .ctext(comment.getCtext())
                .username(comment.getUsername())
                .modifiedTime(Timestamp.valueOf(comment.getModifiedTime()))
                .build();
    }
}
