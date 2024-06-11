package com.itwill.spring2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.spring2.dto.PostListDto;
import com.itwill.spring2.repository.Post;
import com.itwill.spring2.repository.PostDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드들을 초기화하는 아규먼트를 갖는 생성자.
@Service // 스프링 컨테이너에 서비스 컴포넌트로 등록.
public class PostService {
    
    // 애너테이션을 사용한 의존성 주입(DI: Dependency Injection):
    // @Autowired private PostDao postDao;
    
    // 생성자에 의한 의존성 주입:
    // (1) final 필드 선언. (2) final 필드를 초기화하는 생성자 작성.
    private final PostDao postDao;
//    public PostService(PostDao postDao) {
//        this.postDao = postDao;
//    }

    public List<PostListDto> read() {
        log.debug("read()");
        
        List<Post> list = postDao.selectOrderByIdDesc();
        
//        List<PostListDto> result = new ArrayList<>();
//        for (Post p : list) {
//            result.add(PostListDto.fromEntity(p));
//        }
        
        return list.stream()
                .map(PostListDto::fromEntity) // map((x) -> PostListDto.fromEntity(x))
                .toList();
    }
    
}
