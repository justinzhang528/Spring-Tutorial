package com.justin.spring6iocxml;

public class User {

    private String id;
    private String name;
    private Integer age;

    public void Speak(){
        System.out.println(this.id +  this.name + this.age + " is speaking...");
    }
}
