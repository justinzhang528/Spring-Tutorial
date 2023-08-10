package com.justin.spring6iocxml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TestUser {

    public void setValue(List<Integer> nums ){
        nums.add(3);
    }

    @Test
    public void TestUserObject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //1.根據id獲取bean
        User user1 = (User)context.getBean("user");

        //2.根據類型獲取bean
//        User user2 = (User)context.getBean(User.class);

        //3.根據id和類型獲取bean
        User user3 = (User)context.getBean("user",User.class);

        //4.根據interface類型獲取implement的bean
        UserDao userDao = (UserDao)context.getBean("userDaoImpl2");

        userDao.printUserInfo();

        List<Integer> nums = new ArrayList<>();
    }
}
