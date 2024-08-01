package com.itwill.springboot5.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.dto.PostSearchRequestDto;

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
//        result = postRepo.searchByContent("테");
//        result = postRepo.searchByTitleOrContent("jpa");
        
//        LocalDateTime from = LocalDateTime.of(2024, 7, 29, 0, 0);
//        LocalDateTime to = LocalDateTime.of(2024, 7, 30, 23, 59);
//        result = postRepo.searchByModifiedTime(from, to);
        
//        result = postRepo.searchByAuthorAndTitle("guest", "test");
        
//        PostSearchRequestDto dto = new PostSearchRequestDto();
//        dto.setCategory("tc");
//        dto.setKeyword("dum title");
//        result = postRepo.searchByCategory(dto);
        
        String[] keywords = "te dum".split(" "); // { "dum", "title" };
//        result = postRepo.searchByKeywords(keywords);
//        result.forEach(System.out::println);
        
        Pageable pageable = PageRequest.of(1, 5, Sort.by("id").descending());
        Page<Post> page = postRepo.searchByKeywords(keywords, pageable);
        page.forEach(System.out::println);
    }

}
