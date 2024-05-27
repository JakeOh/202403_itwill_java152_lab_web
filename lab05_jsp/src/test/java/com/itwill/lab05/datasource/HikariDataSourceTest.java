package com.itwill.lab05.datasource;

import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariDataSource;

public class HikariDataSourceTest {
    
    private final DataSourceUtil util = DataSourceUtil.getInstance();
    
    @Test
    public void test() {
        System.out.println("test...");
    }

}
