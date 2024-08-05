package com.itwill.springboot5.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot5.domain.Comment;
import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.dto.CommentRegisterDto;
import com.itwill.springboot5.dto.CommentUpdateDto;
import com.itwill.springboot5.repository.CommentRepository;
import com.itwill.springboot5.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {
    
    private final CommentRepository commentRepo;
    private final PostRepository postRepo;

    public Comment create(CommentRegisterDto dto) {
        log.info("create(dto={})", dto);
        
        // 댓글이 달릴 포스트 엔터티를 검색:
        Post post = postRepo.findById(dto.getPostId()).orElseThrow();
        
        // DB 테이블에 저장할 Comment 타입의 엔터티를 생성:
        Comment entity = Comment.builder()
                .post(post)
                .ctext(dto.getCtext())
                .writer(dto.getWriter())
                .build();
        
        // DB에 저장(insert 쿼리 실행)
        commentRepo.save(entity);
        
        return entity;
    }
    
    @Transactional(readOnly = true)
    public Page<Comment> readCommentList(Long postId, int pageNo) {
        log.info("readCommentList(postId={}, pageNo={})", postId, pageNo);
        
        // 댓글들이 달려 있는 포스트 엔터티를 검색:
        Post post = postRepo.findById(postId).orElseThrow();
        
        // 페이징 처리와 정렬을 하기 위한 Pageable 객체 생성:
        Pageable pageable = PageRequest.of(pageNo, 5, Sort.by("modifiedTime").descending());
        
        // DB에서 검색(select 쿼리를 실행)
        Page<Comment> data = commentRepo.findByPost(post, pageable);
        log.info("data.number = {}, data.totalPages = {}",
                data.getNumber(), data.getTotalPages());
        
        return data;
    }
    
    public void delete(Long id) {
        log.info("delete(id={})", id);
        
        commentRepo.deleteById(id);
    }
    
    @Transactional
    //-> 엔터티를 findById 등의 메서드로 검색한 후, 엔터티가 변경되면 자동으로 update 쿼리가 실행됨.
    //-> JpaRepository<T, ID>.save(entity) 메서드를 명시적으로 호출할 필요가 없음. 
    public void update(CommentUpdateDto dto) {
        log.info("update(dto={})", dto);
        
        // 아이디(PK)로 엔터티를 검색:
        Comment entity = commentRepo.findById(dto.getId()).orElseThrow();
        
        // 검색된 엔터티의 필드를 업데이트:
        entity.update(dto.getCtext());
        
        // commentRepo.save(entity)를 명시적으로 호출할 필요 없음.
    }
    
}
