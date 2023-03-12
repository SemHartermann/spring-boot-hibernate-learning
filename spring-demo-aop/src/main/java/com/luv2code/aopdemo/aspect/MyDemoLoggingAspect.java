package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.AroundWithLoggerDemoApp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private static Logger myLogger =
            Logger.getLogger(MyDemoLoggingAspect.class.getName());

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object afterGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //get begin timestamp
        long begin = System.currentTimeMillis();

        //now let's execute the method
        Object res = null;

        try{
            res = proceedingJoinPoint.proceed();
        }catch (Exception e){
            myLogger.warning(e.getMessage());

            throw e;
        }

        //get end timestamp
        long end = System.currentTimeMillis();

        long duration = end - begin;
        myLogger.info("\n====>>>> Duration: " + duration + "ms");

        return res;
    }

    @Before("MyAopExpressions.forDaoPackageNotGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        myLogger.info("====>>>> Executing @Before advice on addAccount");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        myLogger.info("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args = joinPoint.getArgs();

        // loop through args
        for (Object tempArg : args) {

            myLogger.info(tempArg.toString());

            if (tempArg instanceof Account) {
                // downcast and print Account specific stuff
                Account account = (Account) tempArg;

                myLogger.info("account name:" + account.getName());
                myLogger.info("account level:" + account.getLevel());
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
        myLogger.info("\n====>>>> Executing @AfterThrowing on method: " + method);

        myLogger.info("\n====>>>> The exception is: " + exc);

    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint){

        myLogger.info("\n====>>>> Executing @After (finally) advice on method:" + joinPoint.getSignature().toShortString());

    }

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterRunningFindAdvice(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();
        myLogger.info("\n====>>>> Executing @AfterReturning on method: " + method);

        myLogger.info("\n====>>>> result before modify: " + result);

        result.forEach(o -> o.setLevel(o.getLevel().toUpperCase()));

        myLogger.info("\n====>>>> result after modify: " + result);

    }


}
