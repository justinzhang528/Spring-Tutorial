package com.justin.spring.aop.example;

public class CalculatorImpl implements Calculator{
    @Override
    public int add(int a, int b) {
        System.out.println("add...");
        return a+b;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("sub...");
        return a-b;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("mul...");
        return a*b;
    }

    @Override
    public double div(int a, int b) {
        System.out.println("div...");
        return (double) a /b;
    }
}
