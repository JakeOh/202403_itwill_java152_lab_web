package com.itwill.springboot4.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ANSWERS")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AID")
    private Long id;
    
    @ManyToOne // 다대일 관계
    // @JoinColumn 설정을 하지 않은 경우 컬럼 이름: [question]_[Question 엔터티의 ID 컬럼 이름]
    @JoinColumn(name = "QUESTION_ID")
    private Question question;
    
    private String answer;
}
