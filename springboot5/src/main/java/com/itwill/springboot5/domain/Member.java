package com.itwill.springboot5.domain;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
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
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
// onlyExplicitlyIncluded 속성: @EqualsAndHashCode.Include 애너테이션이 설정된 필드만 
// 사용할 것인 지 여부.
// callSuper 속성: superclass의 equals(), hashCode() 메서드를 사용할 것인 지 여부.
@Entity
@Table(name = "MEMBERS")
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @EqualsAndHashCode.Include // username 필드를 equals()와 hashCode()를 재정의할 때 사용.
    @NaturalId // unique 제약조건
    @Basic(optional = false) // not null 제약조건
    @Column(updatable = false) // update 쿼리에서 set 절에서 제외하기 위해서.
    private String username;
    
    @Basic(optional = false)
    private String password;
    
    @Basic(optional = false)
    private String email;
    
}
