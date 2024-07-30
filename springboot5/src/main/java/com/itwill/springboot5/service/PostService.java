package com.itwill.springboot5.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.dto.PostCreateDto;
import com.itwill.springboot5.dto.PostListItemDto;
import com.itwill.springboot5.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepo;
    
    @Transactional(readOnly = true)
    public Page<PostListItemDto> read(int pageNo, Sort sort) {
        log.info("read(pageNo={}, sort={})", pageNo, sort);
        
        // Pageable 객체 생성
        Pageable pageable = PageRequest.of(pageNo, 5, sort);
        
        // 영속성(persistence/repository) 계층의 메서드를 호출해서 엔터티들의 리스트를 가져옴.
        Page<Post> list = postRepo.findAll(pageable);
        log.info("page.totalPages = {}", list.getTotalPages()); // 전체 페이지 개수
        log.info("page.number = {}", list.getNumber()); // 현재 페이지 번호
        log.info("page.hasPrevious = {}", list.hasPrevious()); // 이전 페이지가 있는 지 여부
        log.info("page.hasNext = {}", list.hasNext()); // 다음 페이지가 있는 지 여부
        
        // Page<Post> 객체를 Page<PostListItemDto> 타입으로 변환.
        // (x) -> PostListItemDto.fromEntity(x)
        Page<PostListItemDto> posts = list.map(PostListItemDto::fromEntity);
        
        return posts;
    }
    
    @Transactional
    public Long create(PostCreateDto dto) {
        log.info("create(dto={})", dto);
        
        // 영속성 계층의 메서드를 호출해서 DB insert 쿼리를 실행.
        Post entity = postRepo.save(dto.toEntity());
        log.info("entity = {}", entity);
        
        return entity.getId(); // DB에 insert된 레코드의 PK(id)를 리턴. 
    }
    
}
