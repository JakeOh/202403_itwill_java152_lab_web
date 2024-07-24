package com.itwill.springboot3.repository;

import java.time.LocalDate;
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
    
    // 급여가 어떤 값을 초과하는 직원들의 정보
    // select * from employees where salary > ?
    List<Employee> findBySalaryGreaterThan(double salary);
    
    // 급여가 어떤 값 미만인 직원들의 정보(where salary < ?)
    List<Employee> findBySalaryLessThan(double salary);
    
    // 급여가 어떤 범위 안에 있는 직원들의 정보(where salary between ?1 and ?2)
    List<Employee> findBySalaryBetween(Double start, Double end);
    
    // 입사날짜가 특정 날짜 이전인 직원들의 정보(where hire_date < ?)
    List<Employee> findByHireDateLessThan(LocalDate date);
    
    // 입사날짜가 특정 날짜 이후인 직원들의 정보(where hire_date > ?)
    List<Employee> findByHireDateGreaterThan(LocalDate date);
    
    // 입사날짜가 날짜 범위 안에 있는 직원들의 정보(where hire_date between ?1 and ?2)
    List<Employee> findByHireDateBetween(LocalDate start, LocalDate end);
    
    // 부서 이름으로 직원 검색
    List<Employee> findByDepartmentDepartmentName(String name);
    
    // 근무 도시 이름으로 직원 검색
    List<Employee> findByDepartmentLocationCity(String city);
    
    // 대소문자 구분없이 성(lastName) 또는 이름(firstName)에 문자열이 포함된 직원 찾기:
    List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
    
    
    // JPQL(Java Persistence Query Language)
    // JPA에서 사용하는 "객체지향(object-oriented)" 쿼리 문법.
    // 테이블 이름과 테이블의 컬럼 이름으로 쿼리 문장을 작성하는 것이 아니라,
    // 엔터티 객체 이름과 엔터티 필드 이름으로 쿼리를 작성하는 문법.
    // alias(별명)을 반드시 사용해야 함.
    // 엔터티 이름과 필드 이름은 대소문자를 구분.
    
}
