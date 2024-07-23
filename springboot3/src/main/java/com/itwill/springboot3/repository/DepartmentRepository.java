package com.itwill.springboot3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.springboot3.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
