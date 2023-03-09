package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("execution(void add*())")
    public void beforeAddAdvice(){

        System.out.println("\n====>>>> Executing @Before advice on addAccount");

    }
}
