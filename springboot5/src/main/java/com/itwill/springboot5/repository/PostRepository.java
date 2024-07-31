package com.itwill.springboot5.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itwill.springboot5.domain.Post;

// CRUD + Paging/Sorting
public interface PostRepository extends JpaRepository<Post, Long>, PostQuerydsl {
    // JPA Query Method
    // 제목에 포함된 문자열 대소문자 구분없이 검색하기:
    Page<Post> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);
    
    // 내용에 포함된 문자열 대소문자 구분없이 검색하기:
    Page<Post> findByContentContainingIgnoreCase(String keyword, Pageable pageable);
    
    // 작성자에 포함된 문자열 대소문자 구분없이 검색하기:
    Page<Post> findByAuthorContainingIgnoreCase(String keyword, Pageable pageable);
    
    // JPQL(Java Persistence Query Language): 객체지향 쿼리 언어.
    // 제목 또는 내용에 포함된 문자열 대소문자 구분없이 검색하기:
    // findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(args)
    // findByTitleContainingOrContentContainingAllIgnoreCase(args)
    @Query("select p from Post p "
            + "where upper(p.title) like upper('%' || :keyword || '%') "
            + "or upper(p.content) like upper('%' || :keyword || '%') ")
    Page<Post> findByTitleOrContent(@Param("keyword") String keyword, Pageable pageable);
    
}
