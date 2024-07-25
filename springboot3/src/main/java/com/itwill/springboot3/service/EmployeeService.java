package com.itwill.springboot3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot3.domain.Employee;
import com.itwill.springboot3.dto.EmployeeListItemDto;
import com.itwill.springboot3.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository empRepo;
    
    @Transactional(readOnly = true) // 엔터티 객체들을 읽기 전용으로 검색.
    public Page<EmployeeListItemDto> read(int pageNo, Sort sort) {
        log.info("read(pageNo={}, sort={})", pageNo, sort);
        
        // Pageable 객체 생성: PageRequest.of(페이지번호, 한 페이지의 아이템 개수, 정렬기준)
        Pageable pageable = PageRequest.of(pageNo, 10, sort);
        
        // findAll(Pageable pageable) 메서드를 호출.
        Page<Employee> page = empRepo.findAll(pageable);
        log.info("hasPrevious = {}", page.hasPrevious()); // 이전 페이지가 있는 지 여부
        log.info("hasNext = {}", page.hasNext()); // 다음 페이지가 있는 지 여부
        log.info("getNumber = {}", page.getNumber()); // 현재 Slice(페이지) 번호
        log.info("getTotalPages = {}", page.getTotalPages()); // 전체 페이지 개수
        
        // Page<Employee> 타입을 Page<EmployeeListItemDto> 타입으로 변환해서 리턴.
        // (x) -> EmployeeListItemDto.fromEntity(x)
        return page.map(EmployeeListItemDto::fromEntity);
    }
    
    @Transactional(readOnly = true)
    public Employee read(Integer id) {
        log.info("read(id={})", id);
        
        return empRepo.findById(id).orElseThrow();
    }

}
