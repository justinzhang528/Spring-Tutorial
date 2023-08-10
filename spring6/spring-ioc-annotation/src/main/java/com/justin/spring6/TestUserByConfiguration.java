package com.justin.spring6;

import com.justin.spring6.autowired.controller.UserController;
import com.justin.spring6.config.SpringConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserByConfiguration {
    @Test
    public void TestUserObject(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController userController = (UserController)context.getBean("userController");
        userController.addUser();
    }
}
