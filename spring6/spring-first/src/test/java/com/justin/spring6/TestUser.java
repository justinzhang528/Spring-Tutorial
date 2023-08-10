package com.justin.spring6;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.lang.reflect.InvocationTargetException;

public class TestUser {

    // 定義logger
    private Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testUserObject(){
        //加載spring配置文件，對象創建
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //獲取創建的對象
        User user = (User) context.getBean("user");

        //調用對象方法進行測試
        System.out.println("01. " + user);
        System.out.print("02. ");
        user.add();

        // 使用log4j2手動顯示&添加日誌
        logger.info("####Logging");
    }

    @Test
    public void testUserObjectByReflect() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("com.justin.spring6.User");

        User user = (User)clazz.getDeclaredConstructor().newInstance();

        System.out.println(user);
    }
}
