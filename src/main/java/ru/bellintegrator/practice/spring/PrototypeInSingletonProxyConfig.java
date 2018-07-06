package ru.bellintegrator.practice.spring;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import ru.bellintegrator.practice.spring.hello.GreetingServiceImpl;
import ru.bellintegrator.practice.spring.random.RandomMessage;

@Configuration
public class PrototypeInSingletonProxyConfig {
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.INTERFACES)
    public Message randomMessage() {
        return new RandomMessage();
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingServiceImpl(randomMessage());
    }
}