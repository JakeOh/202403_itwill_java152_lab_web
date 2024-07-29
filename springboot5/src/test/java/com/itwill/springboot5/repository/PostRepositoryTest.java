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
    
    @Test
    public void testSave() {
        // DB 테이블에 저장할 엔터티 객체를 생성:
        Post entity = Post.builder()
                .title("JPA 저장 테스트")
                .content("Sprint Boot + JPA 저장 테스트")
                .author("admin")
                .build();
        log.info("save 전: {}", entity);
        
        // insert 쿼리 실행:
        postRepo.save(entity);
        log.info("save 후: {}", entity);
    }

}
