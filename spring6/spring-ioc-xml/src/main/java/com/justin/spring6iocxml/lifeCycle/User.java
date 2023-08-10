package com.justin.spring6iocxml.lifeCycle;

public class User {
    private String name;

    public User(){
        System.out.println("1 創建對象");
    }
    public String getName() {
        return name;
    }

    public void initMethod(){
        System.out.println("4 初始化");
    }

    public void destroyMethod(){
        System.out.println("6 销毁");
    }

    public void setName(String name) {
        System.out.println("2 設定屬性值");
        this.name = name;
    }
}
