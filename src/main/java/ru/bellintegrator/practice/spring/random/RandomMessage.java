package ru.bellintegrator.practice.spring.random;

import ru.bellintegrator.practice.spring.Message;

import java.util.UUID;

/**
 * Случайно сгенерированное сообщение
 */
public class RandomMessage implements Message {

    private final String message;

    public RandomMessage() {
        message = UUID.randomUUID().toString();
    }

    @Override
    public String value() {
        return message;
    }
}
