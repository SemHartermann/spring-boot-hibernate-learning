package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class DotaCoach implements Coach {

    private FortuneService fortuneService;

    public DotaCoach() {
        System.out.println("DotaCoach: inside constructor");
    }

    @Autowired
    public void setFortuneService(@Qualifier("fileFortuneService") FortuneService fortuneService) {
        System.out.println("DotaCoach: inside setter-method");
        this.fortuneService = fortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Play 15 public games pure day!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
