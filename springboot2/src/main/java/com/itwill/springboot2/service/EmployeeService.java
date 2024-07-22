package com.itwill.springboot2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.springboot2.domain.Employee;
import com.itwill.springboot2.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeService {

    // 생성자에 의한 의존성 주입: (1) RequiredArgsConstructor + (2) final field
    private final EmployeeRepository empRepo;
    
    public List<Employee> read() {
        log.info("read()");
        
        // 영속성(저장소) 계층의 메서드를 호출해서 DB 쿼리를 실행.
        return empRepo.findAll();
    }
    
}
