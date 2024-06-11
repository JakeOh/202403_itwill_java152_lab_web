package com.itwill.spring2.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.spring2.dto.PostListDto;
import com.itwill.spring2.repository.Post;
import com.itwill.spring2.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드들을 초기화하는 생성자.
@Controller
@RequestMapping("/post")
//-> PostController 클래스의 모든 컨트롤러 메서드의 매핑 주소는 "/post"로 시작.
public class PostController {
    
    private final PostService postService; // 생성자에 의한 의존성 주입

    @GetMapping("/list")
    public void list(Model model) {
        log.debug("list()");
        
        // 서비스 컴포넌트의 메서드를 호출, 포스트 목록을 읽어옴 -> 뷰에 전달.
        List<PostListDto> list = postService.read();
        model.addAttribute("posts", list);
        
        // 뷰: /WEB-INF/views/post/list.jsp
    }
    
    @GetMapping("/details")
    public void details(@RequestParam(name = "id") int id, Model model) {
        log.debug("details(id={})", id);
        
        Post post = postService.read(id);
        model.addAttribute("post", post);
    }
    
}
