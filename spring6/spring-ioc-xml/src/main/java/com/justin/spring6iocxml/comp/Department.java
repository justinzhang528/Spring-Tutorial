package com.justin.spring6iocxml.comp;

import java.util.List;

public class Department {
    private String name;
    private Employee employee;

    private List<String> list;

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    private List<String> nameList;


    public Department(){}

    public Department(String name, Employee employee){
        this.name = name;
        this.employee = employee;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public Employee getEmployee(){
        return this.employee;
    }

    public void setList(List<String> list){
        this.list = list;
    }

    public List<String> getList(){
        return this.list;
    }
    public void printInfo(){
        System.out.println(this.name + " / " + this.employee.getName());
    }

}
