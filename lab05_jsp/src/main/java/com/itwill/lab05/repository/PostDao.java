package com.itwill.lab05.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.datasource.DataSourceUtil;
import com.zaxxer.hikari.HikariDataSource;

// MVC 아키텍쳐에서 영속성 계층(repository layer)을 담당하는 클래스.
// DB에서 CRUD(Create, Read, Update, Delete) 작업을 담당.
// DAO(Data Access Object).
public enum PostDao {
    INSTANCE;
    
    private static final Logger log = LoggerFactory.getLogger(PostDao.class);
    private final HikariDataSource ds = DataSourceUtil.getInstance().getDataSource();
    
    // select() 메서드에서 실행할 SQL:
    private static final String SQL_SELECT_ALL = "select * from posts order by id desc";
    
    public List<Post> select() {
        log.debug("select()");
        log.debug(SQL_SELECT_ALL);
        
        List<Post> list = new ArrayList<>(); // SELECT 결과를 저장할 리스트.
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String author = rs.getString("author");
                LocalDateTime createdTime = rs.getTimestamp("created_time").toLocalDateTime();
                LocalDateTime modifiedTime = rs.getTimestamp("modified_time").toLocalDateTime();
                
                Post post = Post.builder()
                        .id(id)
                        .title(title)
                        .content(content)
                        .author(author)
                        .createdTime(createdTime)
                        .modifiedTime(modifiedTime)
                        .build();
                list.add(post);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return list;
    }
    
}
