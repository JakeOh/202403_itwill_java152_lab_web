package com.itwill.springboot5.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.itwill.springboot5.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostSearchTest {
    
    @Autowired private PostRepository postRepo;
    
    @Test
    public void testFindByKeyword() {
        String keyword = "te";
        int p = 0;
        Pageable pageable = PageRequest.of(p, 5, Sort.by("id").descending());
        
//        Page<Post> page = postRepo.findByTitleContainingIgnoreCase(keyword, pageable);
//        Page<Post> page = postRepo.findByContentContainingIgnoreCase(keyword, pageable);
//        Page<Post> page = postRepo.findByAuthorContainingIgnoreCase(keyword, pageable);
        Page<Post> page = postRepo.findByTitleOrContent(keyword, pageable);
        page.forEach(System.out::println);
    }
    
}
