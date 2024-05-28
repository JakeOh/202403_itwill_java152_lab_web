package com.itwill.lab05.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostTest {
    private static final Logger log = LoggerFactory.getLogger(PostTest.class);
    
    private PostDao dao = PostDao.INSTANCE; // singleton 객체
    
    // JUnit 모듈에서 단위 테스트를 하기 위해서 호출하는 메서드.
    // (1) public void. (2) 아규먼트를 갖지 않음.
//    @Test
    public void test() {
        // Post 타입 객체 생성 - Builder 디자인 패턴.
        Post p = Post.builder()
                .title("테스트")
                .author("관리자")
                .content("builder design pattern")
                .id(1)
                .build();
        
        // assertNotNull(arg): arg가 null이 아니면 JUnit 테스트 성공, null이면 테스트 실패.
        // assertNull(arg): arg가 null이면 단위 테스트 성공, null이 아니면 테스트 실패.
        Assertions.assertNotNull(p);
        log.debug("p = {}", p);
    }
    
    @Test
    public void testPostDao() {
        Assertions.assertNotNull(dao); // PostDao 타입 객체가 null이 아니면 단위 테스트 성공.
        log.debug("dao = {}", dao);
        
        List<Post> result = dao.select();
        Assertions.assertEquals(3, result.size());
        for (Post p : result) {
            log.debug(p.toString());
        }
    }

}
