package com.itwill.lab05.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                Post post = fromResultSetToPost(rs);
                list.add(post);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return list;
    }
    
    // posts 테이블에 insert하는 SQL:
    private static final String SQL_INSERT = 
            "insert into posts (title, content, author) values (?, ?, ?)";
    
    public int insert(Post post) {
        log.debug("insert({})", post);
        log.debug(SQL_INSERT);
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, post.getTitle());
            stmt.setString(2, post.getContent());
            stmt.setString(3, post.getAuthor());
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }
    
    // posts 테이블에서 id(PK)로 행 1개를 삭제하는 SQL:
    private static final String SQL_DELETE = "delete from posts where id = ?";
    
    public int delete(int id) {
        log.debug("delete(id={})", id);
        log.debug(SQL_DELETE);
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }
    
    // posts 테이블에서 id(PK)로 검색하는 SQL:
    private static final String SQL_SELECT_BY_ID = "select * from posts where id = ?";
    
    public Post select(int id) {
        log.debug("select(id={})", id);
        log.debug(SQL_SELECT_BY_ID);
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Post post = null;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                post = fromResultSetToPost(rs);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return post;
    }
    
    private static final String SQL_UPDATE = 
            "update posts set title = ?, content = ?, modified_time = systimestamp "
            + "where id = ?";
    
    public int update(Post post) {
        log.debug("update({})", post);
        log.debug(SQL_UPDATE);
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, post.getTitle());
            stmt.setString(2, post.getContent());
            stmt.setInt(3, post.getId());
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }
    
    private Post fromResultSetToPost(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String title = rs.getString("title");
        String content = rs.getString("content");
        String author = rs.getString("author");
        LocalDateTime createdTime = rs.getTimestamp("created_time").toLocalDateTime();
        LocalDateTime modifiedTime = rs.getTimestamp("modified_time").toLocalDateTime();
        
        return Post.builder()
                .id(id)
                .title(title)
                .content(content)
                .author(author)
                .createdTime(createdTime)
                .modifiedTime(modifiedTime)
                .build();
    }
    
    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        // DB 자원들을 해제하는 순서: 생성된 순서의 반대로. rs -> stmt -> conn
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void closeResources(Connection conn, Statement stmt) {
        closeResources(conn, stmt, null);
    }
    
}
