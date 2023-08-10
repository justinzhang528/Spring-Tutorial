package com.justin.spring6iocxml.comp;

public class Employee {
    private String name;

    public Employee(){}

    public Employee(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
