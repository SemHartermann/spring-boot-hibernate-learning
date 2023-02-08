package springdemo;

import org.springframework.stereotype.Component;

@Component
public class CoachImpl implements Coach {

    public CoachImpl() {
        System.out.println("CoachImpl: inside constructor");
    }

    @Override
    public String getDailyWorkout() {
        return null;
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
