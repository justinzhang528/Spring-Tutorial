package com.justin.spring6;

public class User {

    public User(){
        System.out.println("No Parameter Constructor");
    }

    public User(String name){
        System.out.println(name);
    }
    public void add(){
        System.out.println("add...");
    }
}
