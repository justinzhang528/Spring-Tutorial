package com.justin;

import com.justin.bean.ApplicationContext;
import com.justin.bean.impl.AppliationContextImpl;
import com.justin.serivice.UserService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestApplicationContextImpl {
    @Test
    public void TestApplicationContextImplObject() throws Exception {
        ApplicationContext context = new AppliationContextImpl("com.justin");
        Object bean = context.getBean(UserService.class);
        System.out.println(bean);
    }
}
