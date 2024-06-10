package com.itwill.spring2.repository;

import java.util.List;

public interface PostDao {

    // post-mapper.xml에서 id="selectOrderByIdDesc"인 SQL을 실행하는 메서드.
    List<Post> selectOrderByIdDesc();
    
}
