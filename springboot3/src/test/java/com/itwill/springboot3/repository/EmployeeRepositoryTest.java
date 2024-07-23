package com.itwill.springboot3.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot3.domain.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired // 의존성 주입
    private EmployeeRepository empRepo;
    
//    @Test
    public void testDependencyInjection() {
        // EmployeeRepository 객체를 의존성 주입을 받을 수 있는 지 테스트.
        assertThat(empRepo).isNotNull();
        log.info("empRepo={}", empRepo);
        /*
         * Repository<T, ID>
         * |__ CrudRepository<T, ID>, PagingAndSortingRepository<T, ID>
         *     |__ JpaRepository<T, ID>
         *         |__ EmployeeRepository<T, ID>
         *             |__ SimpleJpaRepository<T, ID>
         */
    }
    
    @Test
    public void testFindAll() {
        // employees 테이블 전체 검색 테스트:
        long count = empRepo.count();
        assertThat(count).isEqualTo(107L);
        
        List<Employee> list = empRepo.findAll();
        log.info("employees[0]={}", list.get(0));
    }
    
}
