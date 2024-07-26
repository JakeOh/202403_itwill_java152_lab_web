package com.itwill.springboot4.domain;

import java.util.Set;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "QUESTIONS2")
public class Question2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Basic(optional = false)
    private String question;
    
    @OneToMany
    // Answer2 엔터티에서 @ManyToOne을 사용하지 않고,
    // Question2 엔터티에서만 @OneToMany를 사용한 단방향 연관 관계인 경우,
    // questions2_answers 관계 테이블이 자동으로 생성됨.
    private Set<Answer2> answers;
}
