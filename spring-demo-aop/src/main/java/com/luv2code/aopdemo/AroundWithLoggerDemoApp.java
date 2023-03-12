package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {

    private static Logger myLogger =
            Logger.getLogger(AroundWithLoggerDemoApp.class.getName());



    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\nMain Programm: " + AroundWithLoggerDemoApp.class);

        myLogger.info("Calling getFortune()");

        String data = fortuneService.getFortune();

        myLogger.info("\nMy fortune: " + data);

        myLogger.info("Finished!");

        context.close();
    }

}
