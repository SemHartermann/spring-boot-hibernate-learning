package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DotaCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Play 15 public games pure day!";
    }
}
