package com.itwill.springboot5.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot5.domain.Member;
import com.itwill.springboot5.domain.MemberRole;
import com.itwill.springboot5.dto.MemberSignUpDto;
import com.itwill.springboot5.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
// Spring Security에서 로그인/로그아웃 처리에서 사용할 수 있도록 하기 위해서 
// UserDetailsService 인터페이스를 구현함.
public class MemberService implements UserDetailsService {
    
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepo;

    @Transactional
    public Member create(MemberSignUpDto dto) {
        log.info("create(dto={})", dto);
        
        Member member = memberRepo.save(dto.toEntity(passwordEncoder).addRole(MemberRole.USER));
        // save() -> (1) insert into members, (2) insert into member_roles
        
        return member;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // DB 테이블(members)에 username이 일치하는 사용자가 있으면 UserDetails 타입의
        // 객체를 리턴하고, 그렇지 않으면 UsernameNotFoundException을 던짐.
        
        log.info("loadUserByUsername(username={})", username);
        
        Optional<Member> entity = memberRepo.findByUsername(username);
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new UsernameNotFoundException(username + ": 일치하는 사용자 정보 없음.");
        }
    }
    
}
