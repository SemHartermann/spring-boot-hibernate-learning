package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAopExpressions {

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public static void forDaoPackage(){}

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    public static void getter(){}
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    public static void setter(){}

    @Pointcut("forDaoPackage() && !(getter()||setter())")
    public static void forDaoPackageNotGetterSetter(){}

}
