package ru.bellintegrator.practice.spring.random;

import ru.bellintegrator.practice.spring.GreetingService;
import ru.bellintegrator.practice.spring.Message;

public abstract class RandomGreetingService implements GreetingService {

    @Override
    public String hello() {
        return randomMessage().value();
    }

    protected abstract Message randomMessage();
}
