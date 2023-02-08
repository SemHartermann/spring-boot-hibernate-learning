package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("mylogger.properties")
@PropertySource("sport.properties")
//@ComponentScan("com.luv2code.springdemo")
public class SportConfig {

    @Bean
    public MyLoggerConfig myLoggerConfig(@Value("${root.logger.level}") String rootLoggerLevel,
                                         @Value("${printed.logger.level}") String printedLoggerLevel) {
        return new MyLoggerConfig(rootLoggerLevel, printedLoggerLevel);
    }

    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    // define bean for our swim coach AND inject dependency
    @Bean
    public SwimCoach swimCoach() {
        SwimCoach mySwimCoach = new SwimCoach(sadFortuneService());

        return mySwimCoach;
    }

}