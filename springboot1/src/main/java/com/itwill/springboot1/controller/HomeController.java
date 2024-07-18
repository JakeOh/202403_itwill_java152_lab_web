package com.itwill.springboot1.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itwill.springboot1.dto.Author;
import com.itwill.springboot1.dto.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
    
    @GetMapping("/") // context path(/)로 들어오는 GET 방식 요청을 처리하는 메서드
    public String home(Model model) {
        log.info("home()");
        
        LocalDateTime now = LocalDateTime.now(); // 현재 시간
        model.addAttribute("currentTime", now); // 뷰에 전달하는 데이터
        
        Author author = Author.builder()
                .firstName("찰스").lastName("다윈")
                .build();
        Book book = Book.builder()
                .id(1).title("종의 기원").author(author)
                .build();
        log.info("book: {}", book);
        model.addAttribute("book", book);
        
        return "index";
        //-> 뷰의 이름을 리턴.
        //-> src/main/resources/templates/리턴값.html
    }

}
