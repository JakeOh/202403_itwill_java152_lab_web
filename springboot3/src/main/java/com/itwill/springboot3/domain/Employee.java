package com.itwill.springboot3.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor @Getter @ToString @EqualsAndHashCode
@Entity @Table(name = "EMPLOYEES") // EMPLOYEES 테이블에 매핑되는 엔터티.
public class Employee {

    @Id @Column(name = "EMPLOYEE_ID")
    private Integer id;
    
    // JPA는 camel 표기법의 엔터티 필드 이름을 snake 표기법의 컬럼 이름으로 자동 매핑.
    // 필드: firstName <---> 컬럼 이름: first_name(FIRST_NAME)
    private String firstName;
    
    private String lastName;
    
    private String email;
    
    private String phoneNumber; // column: phone_number
    
    private LocalDate hireDate; // column: hire_date
    
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_ID")
    private Job job;
    
    private Double salary;
    
    private Double commissionPct; // column: commission_pct
    
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;
    
    private Integer departmentId;
}
