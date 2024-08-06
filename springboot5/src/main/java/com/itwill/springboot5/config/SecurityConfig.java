package com.itwill.springboot5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//-> 스프링 컨테이너에서 생성하고 관리하는 설정 컴포넌트.
//-> 스프링 컨테이너에서 필요한 곳에 의존성 주입을 해줌.
public class SecurityConfig {
    
    // Spring Security 5 버전부터 비밀번호는 반드시 암호화를 해야만 함.
    // 만약 비밀번호를 암호화하지 않으면, HTTP 403(access denied, 접근 거부) 또는
    // HTTP 500(internal server error, 내부 서버 오류) 에러가 발새함.
    // 비밀번호를 암호화하는 객체를 스프링 컨테이너가 bean으로 관리해야 함.
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 사용자 관리(로그인, 로그아웃, 회원가입 등)를 위한 서비스 인터페이스.
    // 스프링 부트 애플리케이션에서 스프링 시큐리티를 이용한 로그인/로그아웃을 하려면
    // UserDetailsService 인터페이스를 구현하는 서비스 클래스와
    // UserDetails 인터페이스를 구현하는 엔터티 클래스가 있어야 함.
    // 사용자 엔터티와 사용자 서비스를 구현하기 전에 테스트 용도로 사용할 코드.
    @Bean
    UserDetailsService inMemoryUserDetailsService() {
        // 애플리케이션이 동작 중에 메모리에 임시 저장하는 사용자 객체를 생성:
        UserDetails user1 = User.withUsername("user1") // 로그인 사용자 아이디
                .password(passwordEncoder().encode("1111")) // 암호화된 로그인 비밀번호
                .roles("USER") // 사용자 권한(ADMIN, USER, ...)
                .build(); // User 객체를 생성
        
        UserDetails user2 = User.withUsername("user2")
                .password(passwordEncoder().encode("2222"))
                .roles("ADMIN", "USER")
                .build();
        
        UserDetails user3 = User.withUsername("user3")
                .password(passwordEncoder().encode("3333"))
                .roles("ADMIN")
                .build();
        
        // User 타입 객체 3개를 가지고 있는 UserDetailsService 객체를 생성하고 리턴.
        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
    
    // 스프링 시큐리티 필터 체인 객체(bean)
    // 로그인/로그아웃, 인증 필터에서 필요한 설정을 구성.
    // - 로그인 페이지(뷰), 로그아웃 페이지 설정.
    // - 페이지 접근 권한(ADMIN, USER) 설정.
    // - 인증 설정(로그인 없이 접근 가능한 페이지 vs 로그인해야만 접근 가능한 페이지)
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 시큐리티 관련 설정들을 구성.
        
        // CSRF(Cross Site Request Forgery) 기능을 비활성화:
        // CSRF 기능을 활성화한 경우에는,
        // Ajax POST/PUT/DELETE 요청에서 csrf 토큰을 서버로 전송하지 않으면 HTTP 403 에러가 발생함.
        http.csrf((csrf) -> csrf.disable());
        
        // 로그인 페이지(폼) 설정 - 스프링 시큐리티에서 제공하는 기본 HTML 페이지를 사용.
        http.formLogin(Customizer.withDefaults());
        // TODO: Custom 로그인 HTML 페이지를 사용.
        
        // 페이지 접근 권한, 인증 구성: 아래의 1 또는 2 방법 중 한 가지를 선택.
        // 1. HttpSecurity.authorizeHttpRequests(Customizer customizer) 메서드에서 설정.
        //    -> 장점: 한 곳에서 모든 설정을 구성할 수 있음.
        //    -> 단점: 새로운 요청 경로가 생길 때마다 설정 구성 코드를 수정해야 함.
        // 2. 컨트롤러 메서드에서 애너테이션으로 설정.
        //    (1) SecurityConfig 빈에 @EnableMethodSecurity 애너테이션을 설정.
        //    (2) 각각이 컨트롤러 메서드에서 @PreAuthorize 또는 @PostAuthorize 애너테이션을 설정.
        http.authorizeHttpRequests((auth) -> 
            // 모든 요청 주소에 대해서 (role에 상관없이) 아이디/비밀번호 인증을 하는 경우:
            // auth.anyRequest().authenticated()
    
            // 모든 요청 주소에 대해서 "USER" 권한을 가진 아이디/비밀번호 인증을 하는 경우:
            // auth.anyRequest().hasRole("USER")
        
            // 로그인이 필요한 페이지와 그렇지 않은 페이지를 구분해서 설정 구성:
            auth
            .requestMatchers("/post/create", "/post/details", "/post/modify", 
                    "/post/delete", "/post/update", "/api/comment/*")
            .hasRole("USER")
            .anyRequest()
            .permitAll()
        );
        
        return http.build(); // DefaultSecurityFilterChain 객체를 생성해서 리턴.
    }
    
}
