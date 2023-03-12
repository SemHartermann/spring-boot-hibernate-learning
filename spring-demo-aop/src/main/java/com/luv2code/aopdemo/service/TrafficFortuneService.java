package com.luv2code.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune(){

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Very heavy traffic this moment";

    }

    public String getFortune(boolean tripWire) {
        if (tripWire){
            throw new RuntimeException("Major accident! Highway is closed!");
        }
        return "Very heavy traffic this moment";
    }
}
