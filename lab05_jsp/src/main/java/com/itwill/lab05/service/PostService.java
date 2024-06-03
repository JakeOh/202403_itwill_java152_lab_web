package com.itwill.lab05.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.Post;
import com.itwill.lab05.repository.PostDao;
import com.itwill.lab05.repository.UserDao;

// MVC 웹 아키텍쳐에서 Service(Business) 계층을 담당하는 클래스.
// Persistence(Repository) 계층의 기능을 사용해서 비즈니스 로직을 구현하는 객체.
// Controller(Web) 계층에게 비즈니스 로직 결과를 리턴.
public enum PostService {
    INSTANCE;
    
    private static final Logger log = LoggerFactory.getLogger(PostService.class);
    
    // Persistence(Repository) 계층의 기능(메서드)들을 사용하기 위해서.
    private final PostDao postDao = PostDao.INSTANCE;
    private final UserDao userDao = UserDao.INSTANCE;
    
    public List<Post> read() {
        log.debug("read()");
        
        List<Post> list = postDao.select();
        log.debug("list size = {}", list.size());
        
        return list;
    }
    
    public int create(Post post) {
        log.debug("create(post={})", post);
        
        // Repository 계층의 메서드를 사용해서 DB 테이블에 행을 삽입(insert)
        int result = postDao.insert(post);
        log.debug("insert result = {}", result);
        
        // UserDao 메서드 호출(USERS.POINTS 컬럼 업데이트)
        // 글 작성자에게 10포인트를 줌.
        userDao.updatePoints(post.getAuthor(), 10);
        
        return result; // insert된 행의 개수를 리턴.
    }
    
    public Post read(int id) {
        log.debug("read(id={})", id);
        
        // 영속성 계층의 메서드를 호출해서 DB 테이블에서 id로 검색하는 SQL을 실행.
        Post post = postDao.select(id);
        log.debug("{}", post);
        
        return post; // 컨트롤러에게 검색한 Post 객체를 리턴.
    }
    
    public int delete(int id) {
        log.debug("delete(id={})", id);
        
        int result = postDao.delete(id);
        log.debug("delete result = {}", result);
        
        return result;
    }
    
    public int update(Post post) {
        log.debug("update({})", post);
        
        // 영속성 계층의 메서드를 호출해서 DB posts 테이블을 update.
        int result = postDao.update(post);
        log.debug("update result = {}", result);
        
        return result;
    }
    
}
