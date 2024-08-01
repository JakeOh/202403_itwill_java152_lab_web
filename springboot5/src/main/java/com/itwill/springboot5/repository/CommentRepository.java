package com.itwill.springboot5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.springboot5.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
