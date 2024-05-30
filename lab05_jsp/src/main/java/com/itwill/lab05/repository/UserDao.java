package com.itwill.lab05.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.datasource.DataSourceUtil;
import com.zaxxer.hikari.HikariDataSource;

// DAO(Data Access Object). 데이터베이스 CRUD.
public enum UserDao {
    INSTANCE;
    
    private static final Logger log = LoggerFactory.getLogger(UserDao.class);
    
    private final HikariDataSource ds = DataSourceUtil.getInstance().getDataSource();

    // TODO: users 테이블에 insert SQL 문장 & 메서드
    
}
