package com.itwill.spring2.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.spring2.dto.CommentItemDto;
import com.itwill.spring2.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController // 리턴하는 값은 뷰 이름이 아니라, 클라이언트로 직접 전송(응답)되는 데이터.
@RequestMapping("/api/comment")
public class CommentRestController {
    
    private final CommentService commentService; // 생성자에 의한 의존성 주입

    @GetMapping("/all/{postId}")
    public List<CommentItemDto> getAllCommentByPostId(@PathVariable(name = "postId") int postId) {
        // @PathVariable: 요청 주소의 일부가 변수처럼 변할 수 있는 값일 때,
        // 디스패쳐 서블릿이 요청 주소를 분석해서 메서드의 아규먼트로 전달.
        log.debug("getAllCommentByPostId(postId={})", postId);
        
        // 서비스 컴포넌트의 메서드를 호출해서 해당 포스트의 댓글 목록을 가져옴.
        List<CommentItemDto> list = commentService.readByPostId(postId);
        
        return list;
    }
    
}
