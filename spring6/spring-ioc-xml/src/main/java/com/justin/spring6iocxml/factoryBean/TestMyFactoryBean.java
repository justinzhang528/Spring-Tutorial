package com.justin.spring6iocxml.factoryBean;

import com.justin.spring6iocxml.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyFactoryBean {
    @Test
    public void TestMyFactoryBeanObject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.factoryBean.xml");
        User user = (User)context.getBean("myFactoryBean");
        System.out.println(user);
    }
}
