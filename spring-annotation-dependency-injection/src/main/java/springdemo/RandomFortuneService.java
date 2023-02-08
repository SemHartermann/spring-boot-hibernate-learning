package springdemo;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
    String[] firstFortune = new String[3];

    public RandomFortuneService() {
        firstFortune[0] = "Boom Booyah!";
        firstFortune[1] = "What a booom fortune!";
        firstFortune[2] = "Booyakashaa";
    }

    @Override
    public String getFortune() {
        return firstFortune[(int) (Math.random() * 10) % 3];
    }
}
