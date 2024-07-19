package com.itwill.springboot2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.springboot2.domain.Employee;

// JpaRepository<Entity 클래스, Entity 클래스의 @Id 필드 타입>
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
