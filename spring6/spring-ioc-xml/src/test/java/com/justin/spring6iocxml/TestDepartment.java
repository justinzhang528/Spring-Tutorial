package com.justin.spring6iocxml;

import com.justin.spring6iocxml.comp.Department;
import com.justin.spring6iocxml.comp.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDepartment {
    @Test
    public void TestDepartmentObject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Department department = (Department)context.getBean("department");
        department.printInfo();
        for(String str: department.getNameList()){
            System.out.println(str);
        }
    }
}
