package com.justin.spring6iocxml.auto;

import com.justin.spring6iocxml.User;
import com.justin.spring6iocxml.auto.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    @Test
    public void TestUserObject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.auto.xml");
        UserController userController = (UserController)context.getBean("userController");
        userController.addUser();

    }
}
