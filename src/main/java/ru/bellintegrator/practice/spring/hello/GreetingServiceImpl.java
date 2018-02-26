package ru.bellintegrator.practice.spring.hello;

import ru.bellintegrator.practice.spring.GreetingService;
import ru.bellintegrator.practice.spring.Message;

public class GreetingServiceImpl implements GreetingService {

    private final Message message;

    public GreetingServiceImpl(Message message) {
        this.message = message;
    }

    @Override
    public String hello() {
        return message.value();
    }
}
