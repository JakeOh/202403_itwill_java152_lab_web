package com.itwill.springboot5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.domain.QPost;
import com.querydsl.jpa.JPQLQuery;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostQuerydslImpl extends QuerydslRepositorySupport 
    implements PostQuerydsl {

    public PostQuerydslImpl() {
        super(Post.class);
    }

    @Override
    public Post searchById(Long id) {
        log.info("searchById(id={})", id);
        
        QPost post = QPost.post;
        JPQLQuery<Post> query = from(post); // select p from Post p
        query.where(post.id.eq(id)); // query + where id = ?
        Post entity = query.fetchOne();
        
        return entity;
    }
    
    @Override
    public List<Post> searchByTitle(String keyword) {
        log.info("searchByTitle(keyword={})", keyword);
        
        QPost post = QPost.post;
        JPQLQuery<Post> query = from(post); // select
        query.where(post.title.containsIgnoreCase(keyword)); // where
        query.orderBy(post.id.desc()); // order by
        
        List<Post> result = query.fetch();
        
        return result;
    }
    
    @Override
    public List<Post> searchByContent(String keyword) {
        log.info("searchByContent(keyword={})", keyword);
        
        QPost post = QPost.post;
        JPQLQuery<Post> query = from(post)
                .where(post.content.containsIgnoreCase(keyword))
                .orderBy(post.id.desc());
        
        return query.fetch();
    }
    
}
