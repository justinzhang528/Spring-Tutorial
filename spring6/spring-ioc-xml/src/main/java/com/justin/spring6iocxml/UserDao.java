package com.justin.spring6iocxml;

public interface UserDao {
    public void printUserInfo();
    public void setName(String name);
    public void setAge(Integer age);
    public String getName();
    public Integer getAge();
}
