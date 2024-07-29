package com.itwill.springboot5.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot5.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostRepositoryTest {
    // PostRepository 의존성 주입
    @Autowired private PostRepository postRepo;
    
//    @Test
    public void testDependencyInjection() {
        assertThat(postRepo).isNotNull(); // postRepo 객체가 null이 아니면 테스트 성공.
        log.info("postRepo = {}", postRepo);
    }
    
//    @Test
    public void testFindAll() {
        List<Post> list = postRepo.findAll();
        assertThat(list.size()).isEqualTo(0); // list의 원소 개수가 0이면 성공.
        
        list.forEach(System.out::println); // (x) -> System.out.println(x)
    }
    
//    @Test
    public void testSave() {
        // DB 테이블에 저장할 엔터티 객체를 생성:
        Post entity = Post.builder()
                .title("JPA 저장 테스트")
                .content("Sprint Boot + JPA 저장 테스트")
                .author("admin")
                .build();
        log.info("save 전: {}", entity);
        
        // insert 쿼리 실행: 엔터티 객체의 @Id 설정된 필드가 null인 경우.
        postRepo.save(entity);
        log.info("save 후: {}", entity);
    }
    
//    @Test
    public void testUpdate() {
        // PK(id)로 엔터티를 검색:
        Post entity = postRepo.findById(1L).orElseThrow();
        log.info("findById 결과 = {}", entity);
        
        entity.update("update 테스트 2", "JPA update 테스트 2");
        log.info("update 호출 = {}", entity);
        
        // update 쿼리 실행: 
        // @Id 필드가 null이 아닌 경우(레코드가 있는 경우) & 
        // 엔터티 객체가 DB에 있는 레코드와 다른 경우.
        entity = postRepo.save(entity);
        log.info("save 호출 후 = {}", entity);
    }
    
    @Test
    public void testDelete() {
        postRepo.deleteById(1L);
        // JPA는 id로 select 쿼리를 먼저 실행한 후
        // 엔터티가 존재하는 경우에 delete 쿼리를 실해함.
    }

}
