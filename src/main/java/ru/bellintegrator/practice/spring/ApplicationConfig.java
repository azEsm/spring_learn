package ru.bellintegrator.practice.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.bellintegrator.practice.spring.hello.GreetingServiceImpl;
import ru.bellintegrator.practice.spring.random.RandomMessage;

@Configuration
public class ApplicationConfig {
    @Bean
    @Scope("prototype")
    public Message randomMessage() {
        return new RandomMessage();
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingServiceImpl(randomMessage());
    }
}
