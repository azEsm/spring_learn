package ru.bellintegrator.practice.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.bellintegrator.practice.spring.GreetingService;
import ru.bellintegrator.practice.spring.Message;
import ru.bellintegrator.practice.spring.hello.GreetingServiceImpl;

@Configuration
public class AdditionalConfig {
    @Bean
    public GreetingService helloMessage(Message message) {
        return new GreetingServiceImpl(message);
    }
}
