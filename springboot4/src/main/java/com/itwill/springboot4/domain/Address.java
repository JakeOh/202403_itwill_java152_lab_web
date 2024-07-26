package com.itwill.springboot4.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable // 다른 엔터티 클래스의 필드로 포함되는 객체.
public class Address {
    private int postalCode;
    private String city;
    private String street;
    private int streetNo;
}
