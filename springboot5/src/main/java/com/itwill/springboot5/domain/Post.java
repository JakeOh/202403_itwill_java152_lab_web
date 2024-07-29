package com.itwill.springboot5.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE) @Builder
@Getter
@ToString(callSuper = true) // 상위 클래스의 toString()을 호출해서 toString() 메서드를 작성.
@EqualsAndHashCode(callSuper = true) // 상위 클래스의 필드들도 사용해서 equals(), hashCode() 작성.
@Entity @Table(name = "POSTS")
public class Post extends BaseTimeEntity {
    
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generated as identity
    private Long id;
    
    @Basic(optional = false) // not null
    private String title;
    
    @Basic(optional = false)
    private String content;
    
    @Basic(optional = false)
    private String author;
    
    // update 기능(제목/내용 수정)에서 사용할 공개 메서드
    public Post update(String title, String content) {
        this.title = title;
        this.content = content;
        
        return this;
    }
}
