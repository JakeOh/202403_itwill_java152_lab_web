package com.itwill.springboot5.service;

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
public class MemberService {
    
    private final MemberRepository memberRepo;

    @Transactional
    public Member create(MemberSignUpDto dto) {
        log.info("create(dto={})", dto);
        
        Member member = memberRepo.save(dto.toEntity().addRole(MemberRole.USER));
        // save() -> (1) insert into members, (2) insert into member_roles
        
        return member;
    }
    
}
