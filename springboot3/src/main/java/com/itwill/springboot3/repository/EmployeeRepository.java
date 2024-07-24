package com.itwill.springboot3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.springboot3.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // JPA query method 작성 방법:
    // JPA에서 약속된 키워드들과 엔터티의 필드 이름들을 사용해서 
    // 메서드 이름을 (camel 표기법으로) 작성.
    
    // select * from employees where department_id = ?
    List<Employee> findByDepartmentId(Integer id);
    
    // 이름(firstName)으로 검색:
    // select * from employees where first_name = ?
    List<Employee> findByFirstName(String firstName);
    
    // 이름에 포함된 단어로 검색:
    // select * from employees where first_name like ?
    List<Employee> findByFirstNameContaining(String keyword);
    //-> Containing: 아규먼트에 '%'를 사용할 필요가 없음.
    
    List<Employee> findByFirstNameLike(String keyword);
    //-> Like: 아규먼트에 '%' 또는 '_' 를 사용해야 함.
    
    // 이름에 포함된 단어로 검색, 단어의 대/소문자 구분 없이 검색.
    // select * from employees where upper(first_name) like upper(?)
    List<Employee> findByFirstNameContainingIgnoreCase(String keyword);
    
    // 이름에 포함된 단어로 검색, 단어 대/소문자 구분 없이 검색, 정렬 순서는 이름 내림차순.
    // select * from employees where upper(first_name) like upper(?) order by first_name desc
    List<Employee> findByFirstNameContainingIgnoreCaseOrderByFirstNameDesc(String keyword);
    
}
