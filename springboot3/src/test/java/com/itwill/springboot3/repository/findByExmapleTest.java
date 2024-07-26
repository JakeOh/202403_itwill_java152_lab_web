package com.itwill.springboot3.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.itwill.springboot3.domain.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class findByExmapleTest {
    
    @Autowired
    private EmployeeRepository empRepo;
    
    @Test
    public void test() {
        // firstName이 일치하는 직원 검색:
//        Employee emp = Employee.builder().firstName("Steven").build();
        
        // firstName과 lastName이 일치하는 직원 검색:
        Employee emp = Employee.builder()
                .firstName("Steven").lastName("King").build();
        
        log.info("emp = {}", emp);
        
        Example<Employee> example = Example.of(emp);
        
        List<Employee> list = empRepo.findAll(example);
        list.forEach(System.out::println);
    }

}
