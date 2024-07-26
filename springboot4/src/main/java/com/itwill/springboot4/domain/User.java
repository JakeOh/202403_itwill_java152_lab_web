package com.itwill.springboot4.domain;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USERS")
public class User {
    
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NaturalId // unique 제약조건
    @Basic(optional = false) // not null 제약조건
    private String username;
    
    @Basic(optional = false)
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @Column(length = 1000)
    private String memo;
    
    @Embedded // @Embeddable로 선언된 객체를 포함. 생략 가능.
    private Address address;

}
