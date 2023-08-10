package com.justin.spring6.autowired.service;

import com.justin.spring6.User;
import com.justin.spring6.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    // 注入Dao
    // 第一種方式 屬性注入
//    @Autowired //默認根據類型找到對應對象，完成注入
//    private UserDao userDao;

//    private UserDao userDao;

    // 第二種方式 set方法注入
//    private UserDao userDao;
//
//    @Autowired
//    public void setUserService(UserDao userDao) {
//        this.userDao = userDao;
//    }

    // 第三種方式 構造方法注入（如果只有一個構造函數的話@Autrowired可以省略）
//    @Autowired
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    // 第四種方式 參數形態注入（如果只有一個構造函數的話@Autrowired可以省略）
//    public UserServiceImpl(@Autowired UserDao userDao) {
//        this.userDao = userDao;
//    }

    // 第五種方式 因為實現UserDao的有兩個對象，所以用兩個annotation，根據名稱注入，（不然不知道要拿哪一個對象）
    @Autowired
    @Qualifier(value = "userRedisDaoImpl")
    private UserDao userDao;

    @Override
    public void addUserService() {
        System.out.println("addUserService...");
        userDao.addUserDao();
    }
}
