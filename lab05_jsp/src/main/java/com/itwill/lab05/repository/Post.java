package com.itwill.lab05.repository;

import java.time.LocalDateTime;

// MVC 아키텍쳐에서 Model 역할 클래스. DB의 posts 테이블 컬럼 구조와 같은 클래스.
public class Post {
    private Integer id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdTime; // 컬럼 이름: created_time
    private LocalDateTime modifiedTime; // 컬럼 이름: modified_time
    
    public Post() {}

    public Post(Integer id, String title, String content, String author, 
            LocalDateTime createdTime, LocalDateTime modifiedTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", createdTime="
                + createdTime + ", modifiedTime=" + modifiedTime + "]";
    }
    
    // builder 패턴
    public static PostBuilder builder() {
        return new PostBuilder();
    }
    
    public static class PostBuilder {
        private Integer id;
        private String title;
        private String content;
        private String author;
        private LocalDateTime createdTime;
        private LocalDateTime modifiedTime;
        
        private PostBuilder() {}
        
        public PostBuilder id(Integer id) {
            this.id = id;
            return this;
        }
        
        public PostBuilder title(String title) {
            this.title = title;
            return this;
        }
        
        public PostBuilder content(String content) {
            this.content = content;
            return this;
        }
        
        public PostBuilder author(String author) {
            this.author = author;
            return this;
        }
        
        public PostBuilder createdTime(LocalDateTime createdTime) {
            this.createdTime = createdTime;
            return this;
        }
        
        public PostBuilder modifiedTime(LocalDateTime modifiedTime) {
            this.modifiedTime = modifiedTime;
            return this;
        }
        
        public Post build() {
            return new Post(id, title, content, author, createdTime, modifiedTime);
        }
    }
}
