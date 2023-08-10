package com.justin.spring6;

import org.springframework.stereotype.Component;

@Component(value = "user") // equal to <bean id="user" class="com.justin.spring6.User"/> 可省略(value = "user")，它會自動根據class名稱定義
public class User {
    private String name;
}
