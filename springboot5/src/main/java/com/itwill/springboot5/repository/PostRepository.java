package com.itwill.springboot5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.springboot5.domain.Post;

// CRUD + Paging/Sorting
public interface PostRepository extends JpaRepository<Post, Long> {
    // JPA Query Method 작성:
    
    // JPQL(Java Persistence Query Language): 객체지향 쿼리 언어.
    
}
