package com.justin.serivice.impl;

import com.justin.anno.Bean;
import com.justin.anno.Di;
import com.justin.serivice.UserService;

@Bean
public class UserServiceImpl implements UserService {
    @Di
    private String name;
}
