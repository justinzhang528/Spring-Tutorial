package com.justin.spring.aop.annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class CalculatorImpl implements Calculator {
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
    public int div(int a, int b) {
        System.out.println("div...");
        return a/b;
    }
}
