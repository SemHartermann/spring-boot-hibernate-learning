package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("MyAopExpressions.forDaoPackageNotGetterSetter()")
    public void logToCloudAsync(){
        System.out.println("====>>>> Logging to Cloud in async fashion");
    }
}
