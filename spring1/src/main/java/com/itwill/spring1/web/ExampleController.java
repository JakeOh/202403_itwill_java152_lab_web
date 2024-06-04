package com.itwill.spring1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j //-> private static final Logger log = LoggerFactory.getLogger(ExampleController.class); 코드를 삽입.
@Controller
public class ExampleController {
    
    @GetMapping("/")
    public String home() {
        log.debug("home()");
        
        return "home";
    }

}
