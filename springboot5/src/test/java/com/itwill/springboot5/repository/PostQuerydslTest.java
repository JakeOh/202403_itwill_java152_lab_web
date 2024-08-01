package com.itwill.springboot5.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot5.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostQuerydslTest {
    
    @Autowired private PostRepository postRepo;
    
//    @Test
    public void testSearchById() {
        Post entity = postRepo.searchById(2L);
        log.info("entity = {}", entity);
    }
    
    @Test
    public void test() {
        List<Post> result = null;
//        result = postRepo.searchByTitle("DUMM");
        result = postRepo.searchByContent("테");
        
        result.forEach(System.out::println);
    }

}
