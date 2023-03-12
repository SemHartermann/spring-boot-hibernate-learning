package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("MyAopExpressions.forDaoPackageNotGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("====>>>> Executing @Before advice on addAccount");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args = joinPoint.getArgs();

        // loop through args
        for (Object tempArg : args) {

            System.out.println(tempArg);

            if (tempArg instanceof Account) {
                // downcast and print Account specific stuff
                Account account = (Account) tempArg;

                System.out.println("account name:" + account.getName());
                System.out.println("account level:" + account.getLevel());
            }

        }

    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc"
    )
    public void afterThrowingFindAccountAdvice(
            JoinPoint joinPoint, Throwable exc) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @AfterThrowing on method: " + method);

        System.out.println("\n====>>>> The exception is: " + exc);

    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint){

        System.out.println("\n====>>>> Executing @After (finally) advice on method:" + joinPoint.getSignature().toShortString());

    }

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterRunningFindAdvice(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @AfterReturning on method: " + method);

        System.out.println("\n====>>>> result before modify: " + result);

        result.forEach(o -> o.setLevel(o.getLevel().toUpperCase()));

        System.out.println("\n====>>>> result after modify: " + result);

    }


}
