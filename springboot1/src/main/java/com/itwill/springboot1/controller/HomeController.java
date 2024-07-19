package com.itwill.springboot1.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @GetMapping("/book/list")
    public void bookList(Model model) {
        // return 타입이 void인 경우 뷰의 이름은 요청 주소와 같음.
        log.info("bookList()");
        
        // 도서 목록 더미 데이터를 저장하기 위한 리스트.
        ArrayList<Book> list = new ArrayList<>();
        
        // 더미 데이터 5개를 리스트에 저장.
        for (int i = 1; i <= 5; i++) {
            Book book = Book.builder()
                    .id(i)
                    .title("Title-" + i)
                    .author(Author.builder().firstName("Name-" + i).lastName("LastName").build())
                    .build();
            list.add(book);
        }
        
        Book b = Book.builder().id(10).title("종의 기원").build(); // author = null
        list.add(b);
        
        // 도서 목록을 뷰에 전달.
        model.addAttribute("bookList", list);
        
    }

    @GetMapping("/book/details")
    public void bookDetails(@RequestParam(name = "id") int id, Model model) {
        // 요청 파라미터 id 값을 찾고, 해당 id를 갖는 Book 객체를 만듦.
        // Book 객체를 모델에 속성(attr)으로 저장, 뷰로 전달.
        
        log.info("bookDetails(id={})", id);
        
        Book book = Book.builder()
                .id(id)
                .title("종의 기원")
                .author(Author.builder().firstName("찰스").lastName("다윈").build())
                .build();
        model.addAttribute("book", book);
    }
    
}
