package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = null;

        try{
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        }catch (Exception exc){
            System.out.println("\nMain Programm: " + exc);
        }
        System.out.println("\nMain Programm: " + AfterThrowingDemoApp.class);

        System.out.println("------------------");

        System.out.println(accounts + "\n");

        context.close();
    }

}
