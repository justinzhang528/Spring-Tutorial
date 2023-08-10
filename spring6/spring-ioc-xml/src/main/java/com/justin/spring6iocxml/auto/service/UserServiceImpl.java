package com.justin.spring6iocxml.auto.service;

import com.justin.spring6iocxml.auto.dao.UserDao;

public class UserServiceImpl implements UserService{
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private UserDao userDao;
    @Override
    public void addUserService() {
        System.out.println("addUserService....");
        userDao.addUserDao();
    }
}
