package com.itwill.spring2.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        locations = { "file:src/main/webapp/WEB-INF/application-context.xml" }
)
public class PostDaoTest {

    @Autowired
    private PostDao postDao;
    
    @Test
    public void testSelectAll() {
        Assertions.assertNotNull(postDao);
        
        List<Post> list = postDao.selectOrderByIdDesc();
        for (Post p : list) {
            System.out.println(p);
        }
        
    }
    
}
