package com.justin.spring6iocxml.auto.controller;

import com.justin.spring6iocxml.auto.service.UserService;

public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("userController...");
        userService.addUserService();
    }
}
