package com.itwill.spring2.repository;

public interface UserDao {
    
    User selectByUserid(String userid);
    int insert(User user);

}
