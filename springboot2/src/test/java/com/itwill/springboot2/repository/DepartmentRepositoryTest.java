package com.itwill.springboot2.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot2.domain.Department;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository deptRepo;
    
    @Test
    @Order(1)
    public void test() {
        // DepartmentRepository 객체를 의존성 주입받았음(객체가 생성됨)을 테스트 
        assertThat(deptRepo).isNotNull();
        log.info("deptRepo: {}", deptRepo);
    }
    
    @Test
    @Order(2)
    public void findAllTest() {
        // dept 테이블 전체 검색 테스트: 행의 개수가 4개이면 성공.
        List<Department> list = deptRepo.findAll();
        assertThat(list.size()).isEqualTo(4);
        
        list.forEach(System.out::println);
    }
    
    @Test
    @Order(3)
    public void findByTest() {
        // 부서번호(deptno 컬럼, id 필드)로 검색 테스트
        // 부서번호가 테이블에 있는 경우:
        Department dept1 = deptRepo.findById(10).orElseThrow();
        assertThat(dept1.getId()).isEqualTo(10);
        log.info("dept1: {}", dept1);
        
        // 부서번호가 테이블에 없는 경우:
        boolean isEmpty = deptRepo.findById(100).isEmpty();
        assertThat(isEmpty);
    }

}
