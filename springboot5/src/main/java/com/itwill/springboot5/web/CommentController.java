package com.itwill.springboot5.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.springboot5.domain.Comment;
import com.itwill.springboot5.dto.CommentRegisterDto;
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
        // TODO
        return null;
    }
    
}
