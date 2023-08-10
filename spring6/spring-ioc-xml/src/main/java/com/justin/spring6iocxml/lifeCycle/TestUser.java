package com.justin.spring6iocxml.lifeCycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    @Test
    public void TestUserObjectLifeCycle(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.lifeCycle.xml");
        User user = (User)context.getBean("user");
        context.close();
        System.out.println(user.getName());
    }
}
