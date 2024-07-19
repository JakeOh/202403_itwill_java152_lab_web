package com.itwill.springboot2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.springboot2.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
