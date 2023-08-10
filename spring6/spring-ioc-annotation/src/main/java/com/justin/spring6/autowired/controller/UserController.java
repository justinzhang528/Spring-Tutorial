package com.justin.spring6.autowired.controller;

import com.justin.spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    // 注入Service
    // 第一種方式 屬性注入
//    @Autowired //默認根據類型找到對應對象，完成注入
//    private UserService userService;

    private UserService userService;

    // 第二種方式 set方法注入
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    // 第三種方式 構造方法注入（如果只有一個構造函數的話@Autrowired可以省略）
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    // 第四種方式 參數形態注入（如果只有一個構造函數的話@Autrowired可以省略）
    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("addUserController...");
        userService.addUserService();
    }
}
