package com.justin.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCar {

    //1. 獲取對象的多種方式
    @Test
    public void TestCar1() throws Exception {
        // 1. 類名.class
        Class clazz1 = Car.class;

        // 2. 對象.getClass()
        Class clazz2 = new Car().getClass();

        // 3. Class.forName("全路徑")
        Class clazz3 = Class.forName("com.justin.reflect.Car");

        Car car = (Car)clazz3.getDeclaredConstructor().newInstance();

        System.out.println(car);
    }

    //2. 獲取構造方法
    @Test
    public void TestCar2() throws Exception {
        Class clazz = Car.class;
        // 獲取所有構造
        // getConstructors()是獲取所有public的構造方法
//        Constructor[] constructors = clazz.getConstructors();

        // getDeclaredConstructors()是獲取所有public的構造方法
        Constructor[] constructors = clazz.getDeclaredConstructors();

        for (Constructor c:constructors) {
            System.out.println("構造方法名稱："+c.getName()+" 參數個數："+c.getParameterCount());
        }

        // 指定有參構造創建對象
        // getConstructor()取得public構造方法
        Constructor constructor1 = clazz.getConstructor(String.class, int.class, String.class);
        Car car1 = (Car)constructor1.newInstance("奔馳",25,"白色");
        System.out.println(car1);

        // 指定有參構造創建對象
        // getDeclaredConstructor()取得private構造方法
        Constructor constructor2 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        constructor2.setAccessible(true);
        Car car2 = (Car)constructor2.newInstance("比利",15,"白色");
        System.out.println(car2);
    }

    // 3. 獲取屬性
    @Test
    public void TestCar3() throws  Exception {
        Class clazz = Car.class;
        Car car = (Car)clazz.getDeclaredConstructor().newInstance();
        // 獲取所有public屬性
//        Field[] fields = clazz.getFields();
        // 獲取所有private和public屬性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields) {
            String fieldName = field.getName();
            field.setAccessible(true);
            if(fieldName.equals("name")){
                field.set(car,"BMW");
            } else if (fieldName.equals("age")) {
                field.set(car,10);
            } else {
                field.set(car,"black");
            }
        }
        System.out.println(car.getName());
        System.out.println(car.getAge());
        System.out.println(car.getColor());
    }

    // 4. 獲取方法
    @Test
    public void TestCar4() throws  Exception {
        Car car = new Car("BMW",12,"Pink");
        Class clazz = Car.class;
        // 獲取所有方法（包括public & private）
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method:methods) {
            method.setAccessible(true);
            String methodName = method.getName();
            if(methodName.equals("toString")){
                String string = (String)method.invoke(car);
                System.out.println(string);
            }
            System.out.println(method.getName());
        }
    }
}
