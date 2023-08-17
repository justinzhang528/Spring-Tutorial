package com.justin.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// 切面類
@Aspect // 切面類
@Component //ioc容器
public class LogAspect {

    // 設置切入點和通知類型
    // 切入點表達式：execution(訪問修飾符 增強方法返回類型 增強方法所在類全路徑.方法名稱(參數)) *表示任意
    // 通知類型：
    // 前置 @Before("切入點表達式配置切入點")
    @Before(value = "pointcut()")
    public void foreMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger-->前置通知，方法名稱：" + methodName + "，參數：" + Arrays.toString(args));
    }

    // 返回 @AfterReturning
    @AfterReturning(value = "execution(public int com.justin.spring.aop.annotation.CalculatorImpl.*(..))",returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->返回通知，方法名稱：" + methodName + "，返回值：" + result);
    }

    // 異常 @AfterThrowing 獲取目標方法的異常信息
    @AfterThrowing(value = "execution(public int com.justin.spring.aop.annotation.CalculatorImpl.*(..))",throwing = "exception")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable exception){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->異常通知，方法名稱：" + methodName + "，異常信息：" + exception);
    }

    // 後置 @After()
    @After(value = "pointcut()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->後置通知，方法名稱：" + methodName);
    }

    // 環繞 @Around()
    @Around(value = "pointcut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argString = Arrays.toString(args);
        try{
            System.out.println("環繞通知==目標方法返回值之後");
        }catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("環繞通知==目標方法出現異常執行");
        }finally {
            System.out.println("環繞通知==目標方法執行完畢");
        }
        return null;
    }

    // 重用表達式
    @Pointcut(value = "execution(public int com.justin.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointcut(){}
}
