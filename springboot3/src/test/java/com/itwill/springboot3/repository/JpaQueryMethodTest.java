package com.itwill.springboot3.repository;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot3.domain.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class JpaQueryMethodTest {
    @Autowired
    private EmployeeRepository empRepo;
    
    @Test
    public void test() {
        List<Employee> list;
//        list = empRepo.findByDepartmentId(30);
//        list = empRepo.findByFirstName("Steven");
//        list = empRepo.findByFirstNameContaining("te");
//        list = empRepo.findByFirstNameLike("%te%");
//        list = empRepo.findByFirstNameContainingIgnoreCase("Te");
//        list = empRepo.findByFirstNameContainingIgnoreCaseOrderByFirstNameDesc("TE");
//        list = empRepo.findBySalaryGreaterThan(10_000.0);
//        list = empRepo.findBySalaryLessThan(10_000.);
//        list = empRepo.findBySalaryBetween(10_000., 15_000.);
//        list = empRepo.findByHireDateLessThan(LocalDate.of(2003, 1, 1));
//        list = empRepo.findByHireDateGreaterThan(LocalDate.of(2007, 5, 21));
//        list = empRepo.findByHireDateBetween(LocalDate.of(2007, 1, 1), 
//                LocalDate.of(2007, 12, 31));
//        list = empRepo.findByDepartmentDepartmentName("IT");
//        list = empRepo.findByDepartmentLocationCity("Seattle");
//        list = empRepo.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase("te", "te");
//        list = empRepo.findByName("tE", "Te");
//        list = empRepo.findByName2("te");
        list = empRepo.findByDeptName("IT");
        
        list.forEach(System.out::println);
    }

}
