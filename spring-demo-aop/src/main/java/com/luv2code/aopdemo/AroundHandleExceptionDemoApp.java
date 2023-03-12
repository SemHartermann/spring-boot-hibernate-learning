package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

    private static Logger myLogger =
            Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());



    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\nMain Programm: " + AroundHandleExceptionDemoApp.class);

        myLogger.info("Calling getFortune()");

        boolean tripWire = true;

        String data = fortuneService.getFortune(tripWire);

        myLogger.info("\nMy fortune: " + data);

        myLogger.info("Finished!");

        context.close();
    }

}
