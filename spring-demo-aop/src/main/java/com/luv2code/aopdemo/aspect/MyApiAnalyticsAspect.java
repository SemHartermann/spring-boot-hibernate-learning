package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("MyAopExpressions.forDaoPackageNotGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("====>>>> Performing API analytics");
    }

}
