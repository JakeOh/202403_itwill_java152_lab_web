package com.itwill.spring2.service;

import org.springframework.stereotype.Service;

import com.itwill.spring2.repository.User;
import com.itwill.spring2.repository.UserDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    
    private final UserDao userDao;
    
    // 아이디 중복 체크: true - 중복되지 않은 아이디(사용 가능한 아이디), false - 중복된 아이디.
    public boolean checkUserid(String userid) {
        log.debug("checkUserid(userid={})", userid);
        
        User user = userDao.selectByUserid(userid);
        if (user == null) { // userid가 일치하는 레코드가 없을 때(중복된 아이디가 없는 경우)
            return true;
        } else { // userid가 일치하는 레코드가 있을 때(아이디가 중복된 경우)
            return false;
        }
    }
    
}
