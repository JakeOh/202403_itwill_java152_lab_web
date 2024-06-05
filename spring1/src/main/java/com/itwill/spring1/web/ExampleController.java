package com.itwill.spring1.web;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

// POCO(Plain Old C++(C#) Object)
// POJO(Plain Old Java Object): 간단한 오래된 자바 객체.
// 특정 클래스를 상속(extends)하거나, 특정 인터페이스를 구현(implements)할 필요가 없는
// (상위 타입의 특정 메서드들을 반드시 재정의할 필요가 없는) 평범한 자바 객체.
// 스프링 MVC 프레임워크에서는 POJO로 작성된 클래스를 컨트롤러로 사용할 수 있음!
// (비교) HttpServlet을 상속받는 클래스에서는 doGet(req, resp) 또는 doPost(req, resp)를
// 반드시 재정의(override)해야 웹 서비스(요청 처리)가 가능.

@Slf4j //-> private static final Logger log = LoggerFactory.getLogger(ExampleController.class); 코드를 삽입.
@Controller //-> 디스패쳐 서블릿에게 컨트롤러 컴포넌트임을 알려줌.
// (1) servlet-context.xml 파일에서는 <context:component-scan ... /> 설정.
// (2) 컨트롤러 클래스에서는 @Controller 애너테이션을 사용.
// -> 디스패쳐 서블릿이 컨트롤러 객체를 생성, 관리.
public class ExampleController {
    
    @GetMapping("/")
    public String home(Model model) {
        log.debug("home()");
        
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("now", now);
        // Model 객체는 컨트롤러에서 뷰로 데이터를 전달할 때 사용.
        // request.setAttribute(name, object)와 비슷한 기능.
        
        return "home";
        //-> 컨트롤러 메서드가 문자열을 리턴하면, 디스패쳐 서블릿이 뷰의 이름을 찾는 데 사용.
        // 디스패쳐 서블릿이 뷰 리졸버를 이용해서 /WEB-INF/view/returnValue.jsp 경로를 찾을 수 있음.
    }
    
    @GetMapping("/example")
    public void controllerExample() {
        log.debug("controllerExmaple()");
        // 컨트롤러 메서드가 리턴 값이 없는(void로 선언된) 경우,
        // 요청 주소가 뷰의 이름이 됨.
    }
    
    @GetMapping("/ex1")
    public void example1(@RequestParam(name = "username") String username,
            @RequestParam(name = "age") int age) {
        log.info("exmaple1(username={}, age={})", username, age);
    }

}
