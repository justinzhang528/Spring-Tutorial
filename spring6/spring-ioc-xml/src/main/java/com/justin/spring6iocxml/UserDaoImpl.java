package com.justin.spring6iocxml;

public class UserDaoImpl implements UserDao{
    private String name;
    private Integer age;

    public UserDaoImpl(){}

    public UserDaoImpl(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    @Override
    public void printUserInfo() {
        System.out.println(this.name + " / " + this.age);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }
}
