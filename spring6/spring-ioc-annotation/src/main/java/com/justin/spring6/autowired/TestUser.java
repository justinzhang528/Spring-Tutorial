package com.justin.spring6.autowired;

import com.justin.spring6.autowired.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    @Test
    public void TestUserObject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserController userController = (UserController)context.getBean("userController");
        userController.addUser();
    }
}
