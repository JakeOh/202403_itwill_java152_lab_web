package com.itwill.springboot3.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot3.domain.Department;
import com.itwill.springboot3.domain.Employee;
import com.itwill.springboot3.dto.DepartmentDetailsDto;
import com.itwill.springboot3.repository.DepartmentRepository;
import com.itwill.springboot3.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class DepartmentService {
    
    private final DepartmentRepository deptRepo;
    private final EmployeeRepository empRepo;
    
    @Transactional(readOnly = true)
    public Page<Department> read(int pageNo, Sort sort) {
        log.info("read(pageNo={}, sort={})", pageNo, sort);
        
        Pageable pageable = PageRequest.of(pageNo, 5, sort);
        Page<Department> page = deptRepo.findAll(pageable);
        
        return page;
    }
    
    @Transactional(readOnly = true)
    public DepartmentDetailsDto read(Integer id) {
        log.info("read(id={})", id);
        
        Department department = deptRepo.findById(id).orElseThrow();
        List<Employee> employees = empRepo.findByDepartmentId(id);
        log.info("# of employees = {}", employees.size());
        
        return DepartmentDetailsDto.fromEntity(department, employees);
    }
    
    @Transactional(readOnly = true)
    public DepartmentDetailsDto read(String departmentName) {
        log.info("read(departmentName={})", departmentName);
        //TODO
        return null;
    }

}
