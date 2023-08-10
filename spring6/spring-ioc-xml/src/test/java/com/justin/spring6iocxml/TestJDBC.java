package com.justin.spring6iocxml;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJDBC {
    @Test
    public void TesJDBC(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.jdbc.xml");
        DruidDataSource druidDataSource = (DruidDataSource)context.getBean("druidDataSource");
        System.out.println(druidDataSource.getUrl());
    }
}
