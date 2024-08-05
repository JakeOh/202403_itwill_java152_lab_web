package com.itwill.springboot5.web;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.springboot5.domain.Comment;
import com.itwill.springboot5.dto.CommentRegisterDto;
import com.itwill.springboot5.dto.CommentUpdateDto;
import com.itwill.springboot5.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentSvc;
    
    @PostMapping
    public ResponseEntity<Comment> registerComment(@RequestBody CommentRegisterDto dto) {
        log.info("registgerComment(dto={})", dto);
        
        // 서비스 계층의 메서드 호출(댓글 등록 서비스 실행)
        Comment entity = commentSvc.create(dto);
        log.info("save 결과: {}", entity);
        
        return ResponseEntity.ok(entity);
    }
    
    @GetMapping("/all/{postId}")
    public ResponseEntity<Page<Comment>> getCommentList(
            @PathVariable(name = "postId") Long postId,
            @RequestParam(name = "p", defaultValue = "0") int pageNo) {
        log.info("getCommentList(postId={}, pageNo={})", postId, pageNo);
        
        Page<Comment> data = commentSvc.readCommentList(postId, pageNo);
        
        return ResponseEntity.ok(data);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteComment(@PathVariable Long id) {
        log.info("deleteComment(id={})", id);
        
        commentSvc.delete(id);
        
        return ResponseEntity.ok(id); // 삭제한 댓글 아이디를 응답으로 보냄.
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Long> updateComment(@PathVariable Long id,
            @RequestBody CommentUpdateDto dto) {
        log.info("updateComment(id={}, dto={})", id, dto);
        
        commentSvc.update(dto);
        
        return ResponseEntity.ok(id); // 업데이트한 댓글의 아이디를 응답으로 보냄.
    }
    
}
