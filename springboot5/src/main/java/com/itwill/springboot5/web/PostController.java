package com.itwill.springboot5.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller @RequestMapping("/post")
public class PostController {

    @GetMapping("/list")
    public void list() {
        log.info("list()");
        // TODO: 서비스 계층의 메서드를 호출 -> 뷰에 포스트 목록 전달
    }
    
}
